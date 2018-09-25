package com.infotel.plagiamax.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.infotel.plagiamax.model.User;

/**
 * The Class UserService.
 */
@Service
@Transactional
public class UserService {

	
	/**
	 * Updates a user on Firebase.
	 *
	 * @param user : the user to update
	 */
	public static void patchFirebaseUser(User user) {
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		if (user.getWallet() == null) {
			user.setWallet(0.0);
			DatabaseReference ref2 = database.getReference("users/" + user.getId() + "/id");
			ref2.setValueAsync(user.getId());
			ref2.push();
		}
		
		DatabaseReference ref = database.getReference("users/" + user.getId() + "/wallet");
		ref.setValueAsync(user.getWallet());
		ref.push();
	}
}
