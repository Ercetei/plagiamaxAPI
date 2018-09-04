package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Bet;

@RestController
@RequestMapping(BetLineController.BASE_URL)
public class BetController extends BaseRestController<Bet, Long>{
	public static final String BASE_URL = "/Bet";
}

