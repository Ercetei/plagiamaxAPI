package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Match;

@RestController
@RequestMapping(MatchController.BASE_URL)
public class MatchController extends BaseRestController<Match, Long> {

	public static final String BASE_URL = "/match";
	
	/*item.ifPresent(match -> {
		match.setMatchteams(matchTeamCrudRepository.findByMatchId(match.getId()));
		Optional<Team> teams;
		
		for(MatchTeam matchTeam : match.getMatchteams()) {
			teams = teamCrudRepository.findById(matchTeam.getTeam().getId());
		}
	});*/
}