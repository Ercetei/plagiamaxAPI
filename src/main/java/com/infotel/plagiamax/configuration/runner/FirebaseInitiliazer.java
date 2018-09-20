package com.infotel.plagiamax.configuration.runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.infotel.plagiamax.controller.firebase.Firebase;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.model.firebase.FirebaseDataConfig;
import com.infotel.plagiamax.repository.MatchCrudRepository;
import com.infotel.plagiamax.repository.UserCrudRepository;
import com.infotel.plagiamax.service.MatchService;
import com.infotel.plagiamax.utils.JsonManager;

import net.minidev.json.JSONObject;

@Component
public class FirebaseInitiliazer implements CommandLineRunner {

	@Autowired
	private MatchCrudRepository matchCrud;

	@Autowired
	private UserCrudRepository userCrud;

	Firebase firebase;	
	FirebaseDatabase database;
	
	@Override
	public void run(String... args) throws Exception {
		this.initFirebase();
		this.deleteAll();
		
		Iterable<Match> matchs = (List<Match>) matchCrud.findAll();
		Iterable<User> users = (List<User>) userCrud.findAll();
		
		for (Match match : matchs) {
			JSONObject jsonMatch = MatchService.firebaseParser(match);
			this.sendDataToFirebase("matchs/" + match.getId(), jsonMatch);
		}

		for (User user : users) {
			User newUser = new User();
			newUser.setId(user.getId());
			newUser.setWallet(user.getWallet());
			this.sendDataToFirebase("users/" + user.getId(), newUser);
		}
	}
	
	/**
	 * Firebase initialization; give instance of the firebase database.
	 */
	private void initFirebase() {
		try {
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(new FileInputStream(FirebaseDataConfig.FIREBASE_AUTH)))
					.setDatabaseUrl(JsonManager.getInstance()
							.<FirebaseDataConfig>readFromFile(FirebaseDataConfig.KEY_FILE, FirebaseDataConfig.class)
							.get(0).getUrl())
					.build();
			if (FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.database = FirebaseDatabase.getInstance(FirebaseApp.getInstance());
	}
	
	
	/**
	 * Remove all data from Firebase Database.
	 * @throws UnsupportedEncodingException
	 */
	private void deleteAll() throws UnsupportedEncodingException {
		try {
			this.firebase = new Firebase(JsonManager.getInstance()
					.<FirebaseDataConfig>readFromFile(FirebaseDataConfig.KEY_FILE, FirebaseDataConfig.class).get(0)
					.getUrl());
			this.firebase.delete();

		} catch (FirebaseException e) {
			e.printStackTrace();
		}
		
	}
	
	private void sendDataToFirebase(String path, Object obj) {
		DatabaseReference ref = database.getReference(path);
		ref.setValueAsync(obj);
		ref.push();
	}

}
