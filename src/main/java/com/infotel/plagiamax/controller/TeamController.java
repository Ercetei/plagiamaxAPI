package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Team;

@RestController
@RequestMapping(TeamController.BASE_URL)
public class TeamController extends BaseRestController<Team, Long> {

    public static final String BASE_URL = "/team";
}