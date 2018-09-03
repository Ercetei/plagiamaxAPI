package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.infotel.plagiamax.model.Season;
import com.infotel.plagiamax.repository.SeasonCrudRepository;

@RestController
@RequestMapping("/season")
public class SeasonController {
	
	@Autowired()
	private SeasonCrudRepository seasonCrud;
	private Gson gson = new Gson();

	public SeasonController() { }
	
    @RequestMapping(path={"/", ""}, method=RequestMethod.GET)
    public String index() {
    	Gson gson = new Gson();
    	return gson.toJson(seasonCrud.findAll());
    }
    
    @RequestMapping("/{index}")
    public String getByIndex(@PathVariable("index") Long index) {
    	return gson.toJson(seasonCrud.findById(index));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public String postMyModel(@RequestBody Season season) {
    	return gson.toJson(seasonCrud.save(season));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.PUT)
    public String updateMyModel(@RequestBody Season season) {
    	return gson.toJson(seasonCrud.save(season));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.DELETE)
    public String deleteMyModel(@RequestBody Season season) {
    	seasonCrud.delete(season);
    	
    	return gson.toJson(seasonCrud.findAll());
    }
}