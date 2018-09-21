package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Bet;
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
	
	/** The bet crud repository. */
	@Autowired
	BetCrudRepository betCrudRepository;

}

