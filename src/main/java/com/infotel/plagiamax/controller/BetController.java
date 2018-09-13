package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Bet;
import com.infotel.plagiamax.repository.BetCrudRepository;

@RestController
@RequestMapping(BetController.BASE_URL)
public class BetController extends BaseRestController<Bet, Long>{
	public static final String BASE_URL = "/bet";
	
	@Autowired
	BetCrudRepository betCrudRepository;
	
	@RequestMapping(path = { "/user/{index}"}, method = RequestMethod.GET)
	public ResponseEntity<Iterable<Bet>> findByUser(@PathVariable("index") Long index) {
		Iterable<Bet> items = betCrudRepository.findByUserId(index);
		new ResponseEntity<Bet>(HttpStatus.OK);
		return ResponseEntity.ok(items);
	}
}

