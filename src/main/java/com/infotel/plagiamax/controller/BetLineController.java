package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.BetLine;


// TODO: Auto-generated Javadoc
/**
 * The Class BetLineController.
 */
@RestController
@RequestMapping(BetLineController.BASE_URL)
public class BetLineController extends BaseRestController<BetLine, Long>{
	
	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/betline";
}

