package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Event;

// TODO: Auto-generated Javadoc
/**
 * The Class EventController.
 */
@RestController
@RequestMapping(EventController.BASE_URL)
public class EventController extends BaseRestController<Event, Long>{
	
	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/event";
}
