package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.infotel.plagiamax.model.Category;
import com.infotel.plagiamax.repository.CategoryCrudRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired()
	private CategoryCrudRepository categoryCrud;
	private Gson gson = new Gson();

	public CategoryController() { }
	
    @RequestMapping(path={"/", ""}, method=RequestMethod.GET)
    public String index() {
    	Gson gson = new Gson();
    	return gson.toJson(categoryCrud.findAll());
    }
    
    @RequestMapping("/{index}")
    public String getByIndex(@PathVariable("index") Long index) {
    	return gson.toJson(categoryCrud.findById(index));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public String postMyModel(@RequestBody Category category) {
    	return gson.toJson(categoryCrud.save(category));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.PUT)
    public String updateMyModel(@RequestBody Category category) {
    	return gson.toJson(categoryCrud.save(category));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.DELETE)
    public String deleteMyModel(@RequestBody Category category) {
    	categoryCrud.delete(category);
    	
    	return gson.toJson(categoryCrud.findAll());
    }
}
