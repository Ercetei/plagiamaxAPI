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
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.model.MatchDay;
import com.infotel.plagiamax.repository.MatchBetCrudRepository;
import com.infotel.plagiamax.repository.MatchCrudRepository;

@RestController
@RequestMapping(MatchDayController.BASE_URL)
public class MatchDayController extends BaseRestController<MatchDay, Long> {

    public static final String BASE_URL = "/matchday";
    
	@Autowired
	private MatchBetCrudRepository matchBetCrud;
	
	@Autowired
	private MatchCrudRepository matchCrud;
	
	@RequestMapping(path = { "/{index}/{second}/matchs" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<Match>> getMatchByMatchDay(@PathVariable("index") Long index, @PathVariable("second") Long second) {
		Iterable<Match> item = matchCrud.findByMatchDayId(index, second);
		new ResponseEntity<MatchDay>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}
	
	@RequestMapping(path = { "/{index}/matchbets" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<BetType>> getMatchBetByMatchDay(@PathVariable("index") Long index) {
		Iterable<BetType> item = matchBetCrud.findByMatchDayId(index);
		new ResponseEntity<MatchDay>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}


}