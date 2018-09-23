package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.MatchDay;
import com.infotel.plagiamax.model.Competition;
import com.infotel.plagiamax.repository.MatchDayCrudRepository;

/**
 * The Class CompetitionController.
 */
@RestController
@RequestMapping(CompetitionController.BASE_URL)
public class CompetitionController extends BaseRestController<Competition, Long> {

	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/competition";

	/** The match day crud. */
	@Autowired
	private MatchDayCrudRepository matchDayCrud;

	/**
	 * Gets the matchdays by competition.
	 *
	 * @param index : the competition id
	 * @return all the matchdays for a specific competition
	 */
	@RequestMapping(path = { "/{index}/matchdays" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<MatchDay>> getMatchdaysByCompetition(@PathVariable("index") Long index) {
		Iterable<MatchDay> item = matchDayCrud.findByCompetitionId(index);
		new ResponseEntity<Competition>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}

	/**
	 * Gets the active matchdays by competition.
	 *
	 * @param index : the competition id
	 * @return the matchdays containing matches yet to be played for a specific
	 *         competition
	 */
	@RequestMapping(path = { "/{index}/matchdays/active" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<MatchDay>> getActiveMatchdaysByCompetition(@PathVariable("index") Long index) {
		Iterable<MatchDay> item = matchDayCrud.findActiveByCompetitionId(index);
		new ResponseEntity<Competition>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}
}