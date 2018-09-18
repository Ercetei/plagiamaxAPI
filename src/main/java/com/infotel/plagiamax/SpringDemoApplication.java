package com.infotel.plagiamax;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import com.infotel.plagiamax.model.firebase.FirebaseDataConfig;
import com.infotel.plagiamax.utils.JsonManager;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);

		try {
			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(new FileInputStream(FirebaseDataConfig.FIREBASE_AUTH)))
			  .setDatabaseUrl(JsonManager.getInstance().<FirebaseDataConfig>readFromFile(FirebaseDataConfig.KEY_FILE, FirebaseDataConfig.class).get(0).getUrl())
			  .build();
			FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
