package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Period;

@RestController
@RequestMapping(PeriodController.BASE_URL)
public class PeriodController extends BaseRestController<Period, Long> {

    public static final String BASE_URL = "/period";
}