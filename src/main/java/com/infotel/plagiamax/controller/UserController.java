package com.infotel.plagiamax.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.model.security.SecurityRole;
import com.infotel.plagiamax.repository.UserCrudRepository;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController extends BaseRestController<User, Long> {

	public static final String BASE_URL = "/user";

	@Autowired
	private UserCrudRepository userCrud;

	@RequestMapping(path = { "/register" }, method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> postItem(@RequestBody User newUser) {
		new ResponseEntity<User>(HttpStatus.OK);
		newUser.setEnable(true);
		SecurityRole role = new SecurityRole();
		role.setId((long) 1);
		Set<SecurityRole> set = new HashSet<>();
		set.add(role);
		newUser.setRoles(set);
		userCrud.save(newUser);
		newUser.setPassword(null);

		return ResponseEntity.ok(newUser);
	}
}
