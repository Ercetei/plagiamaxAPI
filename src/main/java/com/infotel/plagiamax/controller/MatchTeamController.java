package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.MatchTeam;

/**
 * The Class MatchTeamController.
 */
@RestController
@RequestMapping(MatchTeamController.BASE_URL)
public class MatchTeamController extends BaseRestController<MatchTeam, Long> {

	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/matchteam";
}
