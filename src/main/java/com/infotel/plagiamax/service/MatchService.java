package com.infotel.plagiamax.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.client.util.ArrayMap;
import com.infotel.plagiamax.model.Event;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.model.MatchBet;
import com.infotel.plagiamax.model.MatchTeam;
import com.infotel.plagiamax.model.Team;
import com.infotel.plagiamax.repository.TeamCrudRepository;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Service
public class MatchService {
	
	@Autowired
	static TeamCrudRepository teamCrud;

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
	public static void managedWinnings(Match match) {
		/**
		 * 1. Faire sortir les matchbets qui �tendent des bettypes
		 * 2. comparer chaque matchbet avec tous les events du match (voir status)
		 * 3. si ils sont �gaux, modifier le status de la betline � 2, sinon 3
		 * 4. si parmis les betlines, aucun n'est � 3 ou 1, on fait le calcul:
		 * bet.momentodds * bet.betamount
		 * 
		 */
		
		Map<Team, Integer> teams = new ArrayMap<Team, Integer>();
		
		for(MatchTeam matchTeam: match.getMatchteams()) {
			//teams.add(matchTeam.getTeam());
			teams.put(matchTeam.getTeam(), getScoreTeam(matchTeam.getTeam(), match));
			System.out.println("test");
		}
		
		for (MatchBet matchBet : match.getMatchbets()) {
		}
	}
	
	private static Integer getScoreTeam(Team team, Match match) {
		
		return teamCrud.getTeamScoreByMatch(team.getId(), match.getId());
	}
}