package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.BetType;

@RestController
@RequestMapping(UserController.BASE_URL)
public class BetTypeController extends BaseRestController<BetType, Long>{
	public static final String BASE_URL = "/BetType";
}
