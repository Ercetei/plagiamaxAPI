package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Team;

// TODO: Auto-generated Javadoc
/**
 * The Class TeamController.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(TeamController.BASE_URL)
public class TeamController extends BaseRestController<Team, Long> {

    /** The Constant BASE_URL. */
    public static final String BASE_URL = "/team";
}