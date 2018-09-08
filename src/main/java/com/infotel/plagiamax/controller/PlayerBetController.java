package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.PlayerBet;


@RestController
@RequestMapping(PlayerBetController.BASE_URL)
public class PlayerBetController extends BaseRestController<PlayerBet, Long>{
	public static final String BASE_URL = "/playerbet";
}