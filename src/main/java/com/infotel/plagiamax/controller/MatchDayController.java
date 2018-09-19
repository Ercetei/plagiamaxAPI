package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.MatchDay;

// TODO: Auto-generated Javadoc
/**
 * The Class MatchDayController.
 */
@RestController
@RequestMapping(MatchDayController.BASE_URL)
public class MatchDayController extends BaseRestController<MatchDay, Long> {

    /** The Constant BASE_URL. */
    public static final String BASE_URL = "/matchday";
    

}