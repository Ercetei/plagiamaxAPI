package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.infotel.plagiamax.model.Competition;
import com.infotel.plagiamax.repository.CompetitionCrudRepository;

@RestController
@RequestMapping("/competition")
public class CompetitionController {
	
	@Autowired()
	private CompetitionCrudRepository competitionCrud;
	private Gson gson = new Gson();

	public CompetitionController() { }
	
    @RequestMapping(path={"/", ""}, method=RequestMethod.GET)
    public String index() {
    	Gson gson = new Gson();
    	return gson.toJson(competitionCrud.findAll());
    }
    
    @RequestMapping("/{index}")
    public String getByIndex(@PathVariable("index") Long index) {
    	return gson.toJson(competitionCrud.findById(index));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public String postMyModel(@RequestBody Competition competition) {
    	return gson.toJson(competitionCrud.save(competition));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.PUT)
    public String updateMyModel(@RequestBody Competition competition) {
    	return gson.toJson(competitionCrud.save(competition));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.DELETE)
    public String deleteMyModel(@RequestBody Competition competition) {
    	competitionCrud.delete(competition);
    	
    	return gson.toJson(competitionCrud.findAll());
    }
}
