package com.infotel.plagiamax.model.firebase;

/**
 * The Class FirebaseDataConfig. 
 * Configures Firebase properties from the firebase-authentication file.
 */
public class FirebaseDataConfig {

	/** The Constant KEY_FILE. */
	public static final String KEY_FILE = "firebaseKey";

	/** The Constant FIREBASE_AUTH. */
	public static final String FIREBASE_AUTH = "./saves/firebase-authentication.json";

	/** The url. */
	private String url;

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
