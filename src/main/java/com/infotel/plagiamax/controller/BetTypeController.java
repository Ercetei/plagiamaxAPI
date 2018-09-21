package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.repackaged.com.google.common.base.Optional;
import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.model.Team;
import com.infotel.plagiamax.repository.MatchCrudRepository;
import com.infotel.plagiamax.repository.TeamCrudRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class BetTypeController.
 */
@RestController
@RequestMapping(BetTypeController.BASE_URL)
public class BetTypeController extends BaseRestController<BetType, Long> {
	
	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/bettype";

	@Autowired
	TeamCrudRepository teamCrud;
	
	@RequestMapping(path = { "/{index}/teams"}, method = RequestMethod.GET)
	public ResponseEntity<Iterable<Team>> index(@PathVariable("index") Long index) {
		Iterable<Team> teams = teamCrud.getTeamsByBettypeId(index);

		new ResponseEntity<Match>(HttpStatus.OK);
		return ResponseEntity.ok(teams);
	}
}
