package com.infotel.plagiamax.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.plagiamax.model.Bet;
import com.infotel.plagiamax.model.BetLine;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.model.Team;
import com.infotel.plagiamax.repository.BetCrudRepository;
import com.infotel.plagiamax.repository.BetLineCrudRepository;
import com.infotel.plagiamax.repository.MatchBetCrudRepository;
import com.infotel.plagiamax.repository.TeamCrudRepository;
import com.infotel.plagiamax.repository.UserCrudRepository;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 * The Service MatchService. Specifies how to persist a match inside Firebase
 * Manages the actions taken on a match
 */
@Service
@Transactional
public class MatchService {

	/** The team crud. */
	@Autowired
	private TeamCrudRepository teamCrud;

	/** The bet line crud. */
	@Autowired
	private BetLineCrudRepository betLineCrud;

	/** The match bet crud. */
	@Autowired
	private MatchBetCrudRepository matchBetCrud;

	/** The user crud. */
	@Autowired
	private UserCrudRepository userCrud;

	/** The bet crud. */
	@Autowired
	private BetCrudRepository betCrud;

	/**
	 * Parse to JSON Object a match component to be send to Firebase Database.
	 *
	 * @param match the match
	 * @return the JSON object
	 */
	public static JSONObject firebaseParser(Match match) {
		JSONObject jsonInfo = new JSONObject();
		jsonInfo.put("id", match.getId());
		jsonInfo.put("status", match.getStatus());
		jsonInfo.put("date", match.getDate());

		// Place
		JSONArray placeArray = new JSONArray();
		if (match.getPlace() != null) {
			JSONObject subJson = new JSONObject();
			subJson.put("id", match.getPlace().getId());
			subJson.put("country", match.getPlace().getCountry());
			subJson.put("city", match.getPlace().getCity());
			subJson.put("stadium", match.getPlace().getStadium());
			placeArray.appendElement(subJson);
		}
		jsonInfo.put("place", placeArray);

		// MatchPlayers
		JSONArray matchPlayersArray = new JSONArray();
		if (match.getMatchplayers() != null) {
			match.getMatchplayers().forEach(player -> {
				JSONObject subJson = new JSONObject();
				subJson.put("id", player.getId());
				subJson.put("enteringtime", player.getEnteringtime());
				subJson.put("exittime", player.getExittime());
				matchPlayersArray.appendElement(subJson);
			});
		}
		jsonInfo.put("matchplayers", matchPlayersArray);

		// Events
		JSONArray eventArray = new JSONArray();
		if (match.getEvents() != null) {
			match.getEvents().forEach(event -> {
				JSONObject subJson = new JSONObject();
				subJson.put("id", event.getId());
				subJson.put("status", event.getStatus());
				subJson.put("statustime", event.getStatustime());
				eventArray.appendElement(subJson);
			});
		}
		jsonInfo.put("events", eventArray);

		// matchteams
		JSONArray matchteamsArray = new JSONArray();
		if (match.getMatchteams() != null) {
			match.getMatchteams().forEach(matchteam -> {
				JSONObject subJson = new JSONObject();
				subJson.put("id", matchteam.getId());
				subJson.put("ishometeam", matchteam.getIshometeam());

				JSONObject teamJson = new JSONObject();
				teamJson.put("id", matchteam.getTeam().getId());
				teamJson.put("label", matchteam.getTeam().getLabel());
				teamJson.put("status", matchteam.getTeam().getStatus());
				teamJson.put("creationdate", matchteam.getTeam().getCreationdate());

				subJson.put("team", teamJson);

				matchteamsArray.appendElement(subJson);
			});
		}
		jsonInfo.put("matchteams", matchteamsArray);

		// matchday
		JSONArray matchdayArray = new JSONArray();
		if (match.getMatchday() != null) {
			JSONObject subJson = new JSONObject();
			subJson.put("id", match.getMatchday().getId());
			subJson.put("label", match.getMatchday().getLabel());
			matchdayArray.appendElement(subJson);
		}
		jsonInfo.put("matchday", matchdayArray);

		// matchbets
		JSONArray matchbetsArray = new JSONArray();
		if (match.getMatchbets() != null) {
			match.getMatchbets().forEach(bets -> {
				JSONObject subJson = new JSONObject();
				subJson.put("id", bets.getId());
				subJson.put("label", bets.getLabel());
				subJson.put("initialodds", bets.getInitialodds());
				subJson.put("currentodds", bets.getCurrentodds());
				subJson.put("status", bets.getStatus());
				subJson.put("type", bets.getType());

				matchbetsArray.appendElement(subJson);
			});
		}
		jsonInfo.put("matchbets", matchbetsArray);

		return jsonInfo;
	}

	/**
	 * Manages the winnings when a match is over and updates the wallet for every
	 * user who won something betting on it.
	 *
	 * @param match the match
	 */
	public void manageWinnings(Match match) {
		/**
		 * 1. Faire sortir les matchbets qui �tendent des bettypes 2. comparer chaque
		 * matchbet avec tous les events du match (voir status) 3. si ils sont �gaux,
		 * modifier le status de la betline � 2, sinon 3 4. si parmis les betlines,
		 * aucun n'est � 3 ou 1, on fait le calcul: bet.momentodds * bet.betamount
		 * 
		 */
		Boolean validBet = false;
		String scoreExact = "";

		// R�cup�ration home team
		Team homeTeam = match.getMatchteams().stream().filter(team -> team.getIshometeam()).findFirst().orElse(null)
				.getTeam();

		// R�cup�ration outsider team
		Team outsiderTeam = match.getMatchteams().stream().filter(team -> !team.getIshometeam()).findFirst()
				.orElse(null).getTeam();

		// R�cup�rer les scores
		int scoreHomeTeam = teamCrud.getTeamScoreByMatch(homeTeam.getId(), match.getId());
		int scoreOutsiderTeam = teamCrud.getTeamScoreByMatch(outsiderTeam.getId(), match.getId());

		// R�cup�rer toutes les betlines concernant le match mis � jour
		List<BetLine> betlines = betLineCrud.getBetLinesByMatch(match.getId());

		/**
		 * V�rifier si l'id de l'�quipe gagnante = id equipe pari Comparer le score avec
		 * le pari
		 */
		for (BetLine betline : betlines) {
			validBet = false;

			// Pour les paris sur l'�quipe gagnante
			if (betline.getBettype().getType() == 1) {
				// R�cup�rer l'�quipe sur laquelle l'utilisateur a pari�
				Team team = matchBetCrud.findById(betline.getBettype().getId()).get().getTeam();

				// Si l'utilisateur a s�lectionn� une �quipe
				if (team != null) {
					// Si l'�quipe domicile gagne et que l'utilisateur a pari� dessus
					if (scoreHomeTeam > scoreOutsiderTeam && team.getId() == homeTeam.getId()) {
						validBet = true;
						// Si l'�quipe ext�rieur gagne et que l'utilisateur a pari� dessus
					} else if (scoreHomeTeam < scoreOutsiderTeam && team.getId() == outsiderTeam.getId()) {
						validBet = true;
					}
					// L'utilisateur a pari� sur un match nul
				} else {
					// Si le match est nul
					if (scoreHomeTeam == scoreOutsiderTeam) {
						validBet = true;
					}
				}

				// Pour les paris sur le score du match
			} else if (betline.getBettype().getType() == 2) {
				scoreExact = scoreHomeTeam + "-" + scoreOutsiderTeam;

				// Si le score est correct
				if (betline.getBettype().getLabel().equals(scoreExact)) {
					validBet = true;
				}

				// Pour les paris sur le nombre de buts
			} else if (betline.getBettype().getType() == 3) {
				// R�cup�ration du nombre de buts sur lequel l'utilisateur a pari�
				Double betGoals = Double.parseDouble(betline.getBettype().getLabel().substring(1));

				// R�cup�ration du nombre de buts du match
				int matchGoals = scoreHomeTeam + scoreOutsiderTeam;

				if (betline.getBettype().getLabel().substring(0, 1).equals("+")) {
					if (matchGoals > betGoals) {
						validBet = true;
					}
				} else if (betline.getBettype().getLabel().substring(0, 1).equals("-")) {
					if (matchGoals < betGoals) {
						validBet = true;
					}
				}

			}

			// Changer le status de betline
			if (validBet == true) {
				betline.setStatus(2);

			} else {
				betline.setStatus(3);
			}

			betLineCrud.save(betline);
		}

		// R�cup�ration des bets dont les betlines ont �t� mises � jour
		Set<Bet> bets = new HashSet<>();
		for (BetLine bl : betlines) {
			bets.add(bl.getBet());
		}

		// Pour chaque bet
		for (Bet bet : bets) {
			int betStatus = 1;

			// Pour chaque betline des bets mis � jour
			for (BetLine betline : bet.getBetlines()) {

				// Si le pari est perdu, on met le statut � perdu et on sort de la boucle
				if (betline.getStatus() == 3) {
					betStatus = 2;
					break;
					// S'il y a encore un pari en cours, on met le statut en cours et on continue
					// l'it�ration
				} else if (betline.getStatus() == 1) {
					betStatus = 0;
				}
			}

			// Si le pari est gagn�
			if (betStatus == 1) {
				// Formattage du portefeuille
				Double updatedWallet = Math
						.round((bet.getMomentodds() * bet.getBetamount() + bet.getUser().getWallet()) * 100.0) / 100.0;
				bet.getUser().setWallet(updatedWallet);

				// MAJ du portefeuille de l'utilisateur
				userCrud.save(bet.getUser());
				UserService.patchFirebaseUser(bet.getUser());

				// MAJ du bet en statut gagn� et sauvegarde
				bet.setStatus(2);
				betCrud.save(bet);

				// Si le pari est perdu
			} else if (betStatus == 2) {
				// MAJ du bet en statut perdu et sauvegarde
				bet.setStatus(3);
				betCrud.save(bet);
			}
		}
	}
}
