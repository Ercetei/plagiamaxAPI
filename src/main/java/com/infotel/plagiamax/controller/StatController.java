package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Stat;

// TODO: Auto-generated Javadoc
/**
 * The Class StatController.
 */
@RestController
@RequestMapping(StatController.BASE_URL)
public class StatController extends BaseRestController<Stat, Long> {

    /** The Constant BASE_URL. */
    public static final String BASE_URL = "/stat";
}