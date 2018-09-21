package com.infotel.plagiamax.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.plagiamax.model.BetLine;
import com.infotel.plagiamax.model.Event;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.model.MatchDay;
import com.infotel.plagiamax.model.MatchTeam;
import com.infotel.plagiamax.model.Team;

import com.infotel.plagiamax.repository.BetLineCrudRepository;
import com.infotel.plagiamax.repository.EventCrudRepository;
import com.infotel.plagiamax.repository.MatchBetCrudRepository;
import com.infotel.plagiamax.repository.TeamCrudRepository;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Service
@Transactional
public class MatchService {
	
	@Autowired
	private EventCrudRepository eventCrud;
	
	@Autowired
	private TeamCrudRepository teamCrud;
	
	@Autowired
	private BetLineCrudRepository betLineCrud;
	
	@Autowired
	private MatchBetCrudRepository matchBetCrud;

	private Long idBetMatch;

	/**
	 * Parse to JSON Object a match component to be send to Firebase Database
	 * @param match
	 * @return
	 */
	public static JSONObject firebaseParser(Match match) {
		JSONObject jsonInfo = new JSONObject();
		jsonInfo.put("id", match.getId());
		jsonInfo.put("status", match.getStatus());

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
	 * Manage the winnings when a match is over and update the wallet
	 * for every user who won something betting on it.
	 * @param match
	 */
	public void managedWinnings(Match match) {
		/**
		 * 1. Faire sortir les matchbets qui étendent des bettypes
		 * 2. comparer chaque matchbet avec tous les events du match (voir status)
		 * 3. si ils sont égaux, modifier le status de la betline à 2, sinon 3
		 * 4. si parmis les betlines, aucun n'est à 3 ou 1, on fait le calcul:
		 * bet.momentodds * bet.betamount
		 * 
		 */
		Team keyWin = new Team();
		Integer valueWin = 0;
		Integer nbGoal = 0 ;
		Boolean theBet = false ;
		Boolean matchNul = false;
		String scoreExact = "" ;
		Float amountWin = 0F ;
//		Long idBetMatch = 0L ;
		Map<Team, Integer> teams = new HashMap<Team, Integer>();
		
		for(MatchTeam matchTeam: match.getMatchteams()) {
			if(matchTeam.getIshometeam()) {
				Integer teamGoal = teamCrud.getTeamScoreByMatch(matchTeam.getTeam().getId(), match.getId());
				teams.put(matchTeam.getTeam(), teamGoal);
				scoreExact = teamGoal.toString() ;
			}
		}	
		
		for(MatchTeam matchTeam: match.getMatchteams()) {
			if(!matchTeam.getIshometeam()) {
				Integer teamGoal = teamCrud.getTeamScoreByMatch(matchTeam.getTeam().getId(), match.getId());
				teams.put(matchTeam.getTeam(), teamGoal);
				scoreExact += "-" + teamGoal ;
			}
		}
		System.out.println(scoreExact);
	
		/**
		 * Comparaison de l'équipe avec l'équipe gagnante
		 *  -si le nombre de but courrant > à équipe gagnante remplace équipe gagnante par équipe courrante 
		 */
		for(Map.Entry<Team, Integer> t : teams.entrySet() ) {
			Team keyCurrent = t.getKey() ;
			Integer valueCurrent = t.getValue() ;
			nbGoal = nbGoal + valueCurrent ;
			System.out.println("Key : " + keyCurrent.getLabel() + " Value : " + valueCurrent);
			
			if (valueCurrent > valueWin) {
				keyWin = t.getKey() ;
				valueWin = t.getValue() ;
				System.out.println("Valeur plus grande");
				matchNul = false ;
			}
			else if(valueCurrent == valueWin){
				matchNul = true;
			}
			
		}
		System.out.println("equipe gagne : " + keyWin.getLabel() + " avec nb but : " + valueWin);
		System.out.println("Nombre de buts : " + nbGoal);
		
		List<BetLine> betlines = betLineCrud.getCurrentBetLineByMatch(match.getId());
		
		/**
		 * Vérifier si l'id de l'équipe gagnante = id equipe pari
		 */
		for (BetLine bl : betlines) {
			theBet = false ;
			// Récuperer l'équipe que l'utilisateur a parié
			Team teamBet = matchBetCrud.findById(bl.getBettype().getId()).get().getTeam() ;
			
			if (bl.getBettype().getType() == 1) {
				
				System.out.println("Type sur Vainqueur");
				
				if (matchNul == false && teamBet != null) {
					
					idBetMatch = teamBet.getId();
					
					System.out.println(keyWin.getId() + " / " + teamBet.getId());
					
					if(keyWin.getId() == idBetMatch) {
						theBet = true ;
					}

				}
				else if (matchNul == true && teamBet == null) {
					theBet = true ;
					System.out.println(bl.getBettype().getLabel());
				}
				
			}
			else if (bl.getBettype().getType() == 2) {
				System.out.println("Type sur Score exact");
				System.out.println(bl.getBettype().getLabel());
				
				if(scoreExact.equals(bl.getBettype().getLabel())) {
					theBet = true ;
				}
				
			}
			else if (bl.getBettype().getType() == 3) {
				System.out.println("Type sur Buts");
				Float testNbGoal = Float.parseFloat(bl.getBettype().getLabel().substring(1)) ;
				System.out.println(nbGoal + " / " + testNbGoal);

				System.out.println(bl.getBettype().getLabel().substring(0,1));
				if ( bl.getBettype().getLabel().substring(0,1).equals("+") ) {
					if (nbGoal > testNbGoal) {
						theBet = true ;
					}
				}else if ( bl.getBettype().getLabel().substring(0,1).equals("-")) {
					if (nbGoal < testNbGoal) {
						theBet = true ;
					}
				}
			}
			
			
			if(theBet == true) {
				System.out.println("Gagné");
				amountWin = bl.getBet().getMomentodds() * bl.getBet().getBetamount() + bl.getBet().getUser().getWallet() ; 
				bl.getBet().getUser().setWallet(amountWin);
				System.out.println("odds : " + bl.getBet().getMomentodds() + " amount : " + bl.getBet().getBetamount());
				System.out.println(bl.getBet().getUser().getWallet());

				bl.setStatus(2);
			}else {
				System.out.println("Perdu");
				bl.setStatus(3);
			}
			System.out.println(bl.getStatus());
			
			
			
		}
		
	}
}
