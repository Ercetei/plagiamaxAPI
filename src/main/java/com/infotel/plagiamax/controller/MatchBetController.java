package com.infotel.plagiamax.controller;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.infotel.plagiamax.model.MyModel;
import com.infotel.plagiamax.repository.MyModelCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/my-model")
public class MatchBetController {

	@Autowired()
	private MyModelCrudRepository mcrud;
	private Gson gson = new Gson();

	public MyModelController() { }
	
    @RequestMapping(path={"/", ""}, method=RequestMethod.GET)
    public String index() {
    	Gson gson = new Gson();
    	return gson.toJson(mcrud.findAll());
    }
    
    @RequestMapping("/{index}")
    public String getByIndex(@PathVariable("index") Long index) {
    	return gson.toJson(mcrud.findById(index));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public String postMyModel(@RequestBody MyModel model) {
    	return gson.toJson(mcrud.save(model));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.PUT)
    public String updateMyModel(@RequestBody MyModel model) {
    	return gson.toJson(mcrud.save(model));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.DELETE)
    public String deleteMyModel(@RequestBody MyModel model) {
    	mcrud.delete(model);
    	
    	return gson.toJson(mcrud.findAll());
    }

}