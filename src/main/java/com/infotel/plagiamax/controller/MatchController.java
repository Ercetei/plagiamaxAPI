package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Match;


@RestController
@RequestMapping(MatchController.BASE_URL)
public class MatchController extends BaseRestController<Match, Long> {

    /** The Constant BASE_URL. */
    public static final String BASE_URL = "/match";
    

}