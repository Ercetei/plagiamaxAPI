package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Competition;

// TODO: Auto-generated Javadoc
/**
 * The Class CompetitionController.
 */
@RestController
@RequestMapping(CompetitionController.BASE_URL)
public class CompetitionController extends BaseRestController<Competition, Long> {

    /** The Constant BASE_URL. */
    public static final String BASE_URL = "/competition";
}