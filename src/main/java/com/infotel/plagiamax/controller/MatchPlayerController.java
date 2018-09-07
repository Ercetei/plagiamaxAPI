package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.MatchPlayer;

@RestController
@RequestMapping(MatchPlayerController.BASE_URL)
public class MatchPlayerController extends BaseRestController<MatchPlayer, Long>{
	public static final String BASE_URL = "/matchplayer";
}
