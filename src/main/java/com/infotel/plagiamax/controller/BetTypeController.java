package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.model.Team;
import com.infotel.plagiamax.repository.TeamCrudRepository;

/**
 * The Class BetTypeController.
 */
@RestController
@RequestMapping(BetTypeController.BASE_URL)
public class BetTypeController extends BaseRestController<BetType, Long> {

	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/bettype";

	/** The team crud. */
	@Autowired
	TeamCrudRepository teamCrud;

	/**
	 * Gets the teams by bettype.
	 *
	 * @param index : the bettype id
	 * @return the teams for a specific matchbet
	 */
	@RequestMapping(path = { "/{index}/teams" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<Team>> getTeamsByBettype(@PathVariable("index") Long index) {
		Iterable<Team> teams = teamCrud.getTeamsByBettypeId(index);

		new ResponseEntity<Team>(HttpStatus.OK);
		return ResponseEntity.ok(teams);
	}
}
