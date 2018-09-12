package com.infotel.plagiamax.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.model.MatchTeam;
import com.infotel.plagiamax.repository.MatchCrudRepository;
import com.infotel.plagiamax.repository.MatchTeamCrudRepository;
import com.infotel.plagiamax.repository.TeamCrudRepository;

@RestController
@RequestMapping(MatchController.BASE_URL)
public class MatchController extends BaseRestController<Match, Long> {

	public static final String BASE_URL = "/match";

	@Autowired
	private MatchCrudRepository matchCrudRepository;
	
	@Autowired
	private MatchTeamCrudRepository matchTeamCrudRepository;
	
	@Autowired
	private TeamCrudRepository teamCrudRepository;

	@RequestMapping("/{index}/teams")
	public ResponseEntity<Optional<Match>> getTeamsByIndex(@PathVariable("index") Long index) {
		Optional<Match> item = matchCrudRepository.findById(index);
		item.ifPresent(match -> {
			match.setMatchteams(matchTeamCrudRepository.findByMatchId(match.getId()));
			
			for(MatchTeam matchTeam : match.getMatchteams()) {
				matchTeam.setTeam(teamCrudRepository.findById(matchTeam.getTeam().getId()).get());
			}
		});
		
		new ResponseEntity<Match>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}
	
	/*item.ifPresent(match -> {
		match.setMatchteams(matchTeamCrudRepository.findByMatchId(match.getId()));
		Optional<Team> teams;
		
		for(MatchTeam matchTeam : match.getMatchteams()) {
			teams = teamCrudRepository.findById(matchTeam.getTeam().getId());
		}
	});*/
}