package com.infotel.plagiamax.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Bet;
import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.model.security.SecurityRole;
import com.infotel.plagiamax.repository.BetCrudRepository;
import com.infotel.plagiamax.repository.UserCrudRepository;
import com.infotel.plagiamax.service.UserService;
import com.infotel.plagiamax.utils.GenericMerger;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController extends BaseRestController<User, Long> {

	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/user";

	/** The bet crud. */
	@Autowired
	private BetCrudRepository betCrud;

	/**
	 * Register user.
	 *
	 * @param newUser the new user
	 * @return the response entity
	 */
	@RequestMapping(path = { "/register" }, method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> registerUser(@RequestBody User newUser) {
		new ResponseEntity<User>(HttpStatus.OK);
		newUser.setEnable(true);
		SecurityRole role = new SecurityRole();
		role.setId((long) 1);
		Set<SecurityRole> set = new HashSet<>();
		set.add(role);
		newUser.setRoles(set);
		((UserCrudRepository) crudRepository).save(newUser);
		newUser.setPassword(null);
		UserService.patchFirebaseUser(newUser);

		return ResponseEntity.ok(newUser);
	}

	/**
	 * Gets the bet by user.
	 *
	 * @param index the index
	 * @return the bet by user
	 */
	@RequestMapping(path = { "/{index}/bets" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<Bet>> getBetByUser(@PathVariable("index") Long index) {
		Iterable<Bet> item = betCrud.findByUserId(index);
		new ResponseEntity<User>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}

	@RequestMapping(path = { "/{index}" }, method = RequestMethod.PATCH)
	public ResponseEntity<User> updatefields(@PathVariable("index") Long index, @RequestBody User user) {
		Optional<User> userToUpdate = ((UserCrudRepository) crudRepository).findById(index);
		User updatedUser = GenericMerger.<User>merge(userToUpdate.get(), user, user.getClass());
		UserService.patchFirebaseUser(updatedUser);

		return ResponseEntity.ok(((UserCrudRepository) crudRepository).save(updatedUser));
	}



}
