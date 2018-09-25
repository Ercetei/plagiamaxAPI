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
		DatabaseReference ref = database.getReference("users/" + user.getId() + "/wallet");
		ref.setValueAsync(user.getWallet());
		ref.push();
	}
}
