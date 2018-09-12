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
import com.infotel.plagiamax.model.MatchBet;
import com.infotel.plagiamax.repository.MatchBetCrudRepository;

@RestController
@RequestMapping(MatchBetController.BASE_URL)
public class MatchBetController extends BaseRestController<MatchBet, Long> {
	public static final String BASE_URL = "/matchbet";

	@Autowired
	MatchBetCrudRepository matchBetCrudRepository;

	@RequestMapping(path = { "/user/{index}" }, method = RequestMethod.GET)
	public ResponseEntity<List<BetType>> findByUserId(@PathVariable("index") Long index) {
		List<BetType> matchBets = matchBetCrudRepository.findByUserId(index);
		new ResponseEntity<BetType>(HttpStatus.OK);
		return ResponseEntity.ok(matchBets);
	}
}
