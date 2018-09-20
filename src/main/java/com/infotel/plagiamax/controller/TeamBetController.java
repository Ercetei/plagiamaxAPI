package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.TeamBet;

// TODO: Auto-generated Javadoc
/**
 * The Class TeamBetController.
 */
@RestController
@RequestMapping(TeamBetController.BASE_URL)
public class TeamBetController extends BaseRestController<TeamBet, Long>{
	
	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/teambet";
}
