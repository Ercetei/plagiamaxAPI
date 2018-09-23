package com.infotel.plagiamax.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Bet;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.repository.BetCrudRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class BetController.
 */
@RestController
@RequestMapping(BetController.BASE_URL)
public class BetController extends BaseRestController<Bet, Long>{
	
	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/bet";

	@RequestMapping(path = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<Bet>> index() {
		Iterable<Bet> bets = ((BetCrudRepository) crudRepository).findAll();

		new ResponseEntity<Match>(HttpStatus.OK);
		return ResponseEntity.ok(bets);
	}
}

