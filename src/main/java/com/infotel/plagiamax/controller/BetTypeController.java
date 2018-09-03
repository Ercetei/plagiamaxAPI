package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.repository.BetTypeCrudRepository;

@RestController
@RequestMapping("/bettype")
public class BetTypeController {
	@Autowired()
	private BetTypeCrudRepository betTypeCrud;
	private Gson gson = new Gson();

	public BetTypeController() { }
	
	
	
	@RequestMapping(path={"/", ""}, method=RequestMethod.GET)
    public String index() {
    	Gson gson = new Gson();
    	return gson.toJson(betTypeCrud.findAll());
    }
    
    @RequestMapping("/{index}")
    public String getByIndex(@PathVariable("index") Long index) {
    	return gson.toJson(betTypeCrud.findById(index));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public String postMyModel(@RequestBody BetType betType) {
    	return gson.toJson(betTypeCrud.save(betType));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.PUT)
    public String updateMyModel(@RequestBody BetType betType) {
    	return gson.toJson(betTypeCrud.save(betType));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.DELETE)
    public String deleteMyModel(@RequestBody BetType betType) {
    	betTypeCrud.delete(betType);
    	
    	return gson.toJson(betTypeCrud.findAll());
    }

}
