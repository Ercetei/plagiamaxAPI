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

@RestController
@RequestMapping(value = { "/firebase" })
public class FirebaseController {

	Firebase firebase;

	public FirebaseController() {

		try {
			this.firebase = new Firebase(JsonManager.getInstance()
					.<FirebaseDataConfig>readFromFile(FirebaseDataConfig.KEY_FILE, FirebaseDataConfig.class).get(0)
					.getUrl());
		} catch (FirebaseException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/test" }, method = RequestMethod.POST)
	public ResponseEntity<FirebaseResponse> postM2ToFirebase(@RequestBody Object obj)
			throws UnsupportedEncodingException, FirebaseException {
		return ResponseEntity.ok(this.firebase.post(JsonManager.getInstance().addItem(obj).toJSON()));
	}
}