package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Place;

@RestController
@RequestMapping(PlaceController.BASE_URL)
public class PlaceController extends BaseRestController<Place, Long> {

    public static final String BASE_URL = "/place";
}