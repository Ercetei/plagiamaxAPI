package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.model.MatchDay;

@RestController
@RequestMapping(MatchController.BASE_URL)
public class MatchDayController extends BaseRestController<MatchDay, Long> {

    public static final String BASE_URL = "/matchday";
}