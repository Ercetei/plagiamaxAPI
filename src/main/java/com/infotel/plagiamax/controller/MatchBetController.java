package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.MatchBet;

@RestController
@RequestMapping(MatchBetController.BASE_URL)
public class MatchBetController extends BaseRestController<MatchBet, Long>{
	public static final String BASE_URL = "/matchbet";
}
