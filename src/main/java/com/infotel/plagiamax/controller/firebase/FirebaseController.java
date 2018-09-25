package com.infotel.plagiamax.controller.firebase;

import java.io.UnsupportedEncodingException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.model.firebase.FirebaseDataConfig;
import com.infotel.plagiamax.model.firebase.FirebaseResponse;
import com.infotel.plagiamax.utils.JsonManager;
import com.google.firebase.FirebaseException;

/**
 * The Class FirebaseController. Instantiates and creates transactions with the
 * Firebase object.
 */
@RestController
@RequestMapping(value = { "/firebase" })
public class FirebaseController {

	/** The firebase. */
	Firebase firebase;

	/**
	 * Instantiates a new firebase controller.
	 */
	public FirebaseController() {

		try {
			this.firebase = new Firebase(JsonManager.getInstance()
					.<FirebaseDataConfig>readFromFile(FirebaseDataConfig.KEY_FILE, FirebaseDataConfig.class).get(0)
					.getUrl());
		} catch (FirebaseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Post M 2 to firebase.
	 *
	 * @param obj the obj
	 * @return the response entity
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 * @throws FirebaseException            the firebase exception
	 */
	@RequestMapping(value = { "/test" }, method = RequestMethod.POST)
	public ResponseEntity<FirebaseResponse> postM2ToFirebase(@RequestBody Object obj)
			throws UnsupportedEncodingException, FirebaseException {
		return ResponseEntity.ok(this.firebase.post(JsonManager.getInstance().addItem(obj).toJSON()));
	}
}