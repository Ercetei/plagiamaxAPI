package com.infotel.plagiamax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.model.MatchDay;
import com.infotel.plagiamax.repository.MatchBetCrudRepository;
import com.infotel.plagiamax.repository.MatchCrudRepository;


/**
 * The Class MatchDayController.
 */

@RestController
@RequestMapping(MatchDayController.BASE_URL)
public class MatchDayController extends BaseRestController<MatchDay, Long> {

    /** The Constant BASE_URL. */
    public static final String BASE_URL = "/matchday";
    
	@Autowired
	private MatchBetCrudRepository matchBetCrud;
	
	@Autowired
	private MatchCrudRepository matchCrud;
	
	@RequestMapping(path = { "/{index}/matchs" }, method = RequestMethod.GET)
	public ResponseEntity<List<Match>> getMatchsByMatchDay(@PathVariable("index") Long index) {
		List<Match> items = matchCrud.findByMatchdayId(index);
		new ResponseEntity<Match>(HttpStatus.OK);
		return ResponseEntity.ok(items);
	}
	
	@RequestMapping(path = { "/{index}/matchbets" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<BetType>> getMatchBetByMatchDay(@PathVariable("index") Long index) {
		Iterable<BetType> items = matchBetCrud.findByMatchDayId(index);
		new ResponseEntity<BetType>(HttpStatus.OK);
		return ResponseEntity.ok(items);
		
	}


}