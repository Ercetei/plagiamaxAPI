package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Season;

/**
 * The Class SeasonController.
 */
@RestController
@RequestMapping(SeasonController.BASE_URL)
public class SeasonController extends BaseRestController<Season, Long> {

	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/season";
}