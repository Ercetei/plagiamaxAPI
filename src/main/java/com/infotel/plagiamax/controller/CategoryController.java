package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Category;

/**
 * The Class CategoryController.
 */
@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController extends BaseRestController<Category, Long> {

	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/category";
}