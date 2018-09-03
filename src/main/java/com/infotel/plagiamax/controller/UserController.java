package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.repository.UserCrudRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired()
	private UserCrudRepository userCrud;
	private Gson gson = new Gson();

	public UserController() { }
	
    @RequestMapping(path={"/", ""}, method=RequestMethod.GET)
    public String index() {
    	Gson gson = new Gson();
    	return gson.toJson(userCrud.findAll());
    }
    
    @RequestMapping("/{index}")
    public String getByIndex(@PathVariable("index") Long index) {
    	return gson.toJson(userCrud.findById(index));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.POST)
    public String postMyModel(@RequestBody User user) {
    	return gson.toJson(userCrud.save(user));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.PUT)
    public String updateMyModel(@RequestBody User user) {
    	return gson.toJson(userCrud.save(user));
    }
    
    @RequestMapping(value={"/", ""}, method=RequestMethod.DELETE)
    public String deleteMyModel(@RequestBody User user) {
    	userCrud.delete(user);
    	
    	return gson.toJson(userCrud.findAll());
    }

}
