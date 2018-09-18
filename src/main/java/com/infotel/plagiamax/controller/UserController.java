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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.Bet;
import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.model.security.SecurityRole;
import com.infotel.plagiamax.repository.BetCrudRepository;
import com.infotel.plagiamax.repository.UserCrudRepository;
import com.infotel.plagiamax.utils.GenericMerger;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController extends BaseRestController<User, Long> {

	public static final String BASE_URL = "/user";

	@Autowired
	private UserCrudRepository userCrud;
	
	@Autowired
	private BetCrudRepository betCrud;

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
		userCrud.save(newUser);
		newUser.setPassword(null);
		patchFirebaseUser(newUser);
		
		return ResponseEntity.ok(newUser);
	}
	
	@RequestMapping(path = { "/{index}/bets" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<Bet>> getBetByUser(@PathVariable("index") Long index) {
		Iterable<Bet> item = betCrud.findByUserId(index);
		new ResponseEntity<User>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}
	
	@RequestMapping(path = { "/{index}" }, method = RequestMethod.PATCH)
	public ResponseEntity<User> updatefields(@PathVariable("index") Long index, @RequestBody User user) {
		Optional<User> userToUpdate = userCrud.findById(index);
		User updatedUser = GenericMerger.<User>merge(userToUpdate.get(), user, user.getClass());
		patchFirebaseUser(updatedUser);

		return ResponseEntity.ok(userCrud.save(updatedUser));
	}

	public void patchFirebaseUser(User user) {
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("users/" + user.getId() + "/wallet");
		ref.setValueAsync(user.getWallet());
		ref.push();
	}
	
}
