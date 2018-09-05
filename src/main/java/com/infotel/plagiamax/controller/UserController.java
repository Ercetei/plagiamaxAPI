package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.repository.UserCrudRepository;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController extends BaseRestController<User, Long> {

    public static final String BASE_URL = "/user";
    
    @Autowired
	private UserCrudRepository userCrudRepository;
    
    @RequestMapping(path={"/connect"}, method=RequestMethod.POST)
    public ResponseEntity<User> connectUser(@RequestBody User user) {
        User userToConnect = userCrudRepository.findByMailAndPassword(user.getMail(), user.getPassword());
    	new ResponseEntity<User>(HttpStatus.OK);
		return ResponseEntity.ok(userToConnect);
    }
}
