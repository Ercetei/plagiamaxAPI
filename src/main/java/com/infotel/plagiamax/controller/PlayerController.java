package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Player;

@RestController
@RequestMapping(PlayerController.BASE_URL)
public class PlayerController extends BaseRestController<Player, Long> {

    public static final String BASE_URL = "/player";
}