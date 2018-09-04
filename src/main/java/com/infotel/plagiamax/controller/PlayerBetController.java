package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;


@RestController
@RequestMapping(PlayerBetController.BASE_URL)
public class PlayerBetController extends BaseRestController<PlayerBetController, Long>{
	public static final String BASE_URL = "/PlayerBet";
}
