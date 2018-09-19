package com.infotel.plagiamax.configuration.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.userdetails.User;
import com.infotel.plagiamax.repository.UserCrudRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {
	
	/** The Constant LOGIN. */
	private static final String LOGIN = "login/login";
	
	/** The user crud. */
	@Autowired
	UserCrudRepository userCrud;

	/**
	 * Login get.
	 *
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String loginGet(HttpSession session) {
		return LOGIN;
	}
	
	/**
	 * Login post.
	 *
	 * @return the response entity
	 */
	@RequestMapping(path = "/loginResult", method = RequestMethod.GET)
	public ResponseEntity<com.infotel.plagiamax.model.User> loginPost() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User userDetails = (User)auth.getPrincipal();
		com.infotel.plagiamax.model.User user = userCrud.findByUsername(userDetails.getUsername());
		user.setPassword(null);
        return ResponseEntity.ok(user);
	}
}
