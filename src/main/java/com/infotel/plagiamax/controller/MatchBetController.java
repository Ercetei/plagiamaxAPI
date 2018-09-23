package com.infotel.plagiamax.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.model.MatchBet;
import com.infotel.plagiamax.repository.MatchBetCrudRepository;

/**
 * The Class MatchBetController.
 */
@RestController
@RequestMapping(MatchBetController.BASE_URL)
public class MatchBetController extends BaseRestController<MatchBet, Long> {
	
	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/matchbet";

	/**
	 * Find by user id.
	 *
	 * @param index the index
	 * @return the response entity
	 */
	@RequestMapping(path = { "/user/{index}" }, method = RequestMethod.GET)
	public ResponseEntity<List<BetType>> findByUserId(@PathVariable("index") Long index) {
		List<BetType> matchBets = ((MatchBetCrudRepository) crudRepository).findByUserId(index);
		new ResponseEntity<BetType>(HttpStatus.OK);
		return ResponseEntity.ok(matchBets);
	}
}
