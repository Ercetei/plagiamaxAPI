package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.infotel.plagiamax.model.Bet;
import com.infotel.plagiamax.repository.BetCrudRepository;

@RestController
@RequestMapping("/bet")
public class BetController {
	@Autowired()
	private BetCrudRepository betCrud;
	private Gson gson = new Gson();
	
	public BetController() { }
	
	@RequestMapping(path={"/", ""}, method=RequestMethod.GET)
    public String index() {
    	Gson gson = new Gson();
    	return gson.toJson(betCrud.findAll());
    }
    
    @RequestMapping("/{index}")
    public String getByIndex(@PathVariable("index") Long index) {
    	return gson.toJson(betCrud.findById(index));
    }
   
    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public String postMyModel(@RequestBody Bet bet) {
    	return gson.toJson(betCrud.save(bet));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.PUT)
    public String updateMyModel(@RequestBody Bet bet) {
    	return gson.toJson(betCrud.save(bet));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.DELETE)
    public String deleteMyModel(@RequestBody Bet bet) {
    	betCrud.delete(bet);
    	
    	return gson.toJson(betCrud.findAll());
    }

}
