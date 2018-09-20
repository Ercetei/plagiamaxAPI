package com.infotel.plagiamax.model.firebase;

public class FirebaseDataConfig {
	
	public static final String KEY_FILE = "firebaseKey";
	public static final String FIREBASE_AUTH = "./saves/firebase-authentication.json";

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
