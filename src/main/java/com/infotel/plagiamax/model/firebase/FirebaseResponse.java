package com.infotel.plagiamax.model.firebase;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Class FirebaseResponse. 
 * Manages the Firebase responses
 */
public class FirebaseResponse {

///////////////////////////////////////////////////////////////////////////////
//
//PROPERTIES & CONSTRUCTORS
//
///////////////////////////////////////////////////////////////////////////////

	/** The success. */
	private final boolean success;

	/** The code. */
	private final int code;

	/** The body. */
	private final Map<String, Object> body;

	/** The raw body. */
	private final String rawBody;

	/**
	 * Instantiates a new firebase response.
	 *
	 * @param success the success
	 * @param code    the code
	 * @param body    the body
	 * @param rawBody the raw body
	 */
	public FirebaseResponse(boolean success, int code, Map<String, Object> body, String rawBody) {

		this.success = success;
		this.code = code;

		if (body == null) {
			System.err.println("body was null; replacing with empty map");
			body = new LinkedHashMap<String, Object>();
		}
		this.body = body;

		if (rawBody == null) {
			System.err.println("rawBody was null; replacing with empty string");
			rawBody = new String();
		}
		this.rawBody = rawBody.trim();
	}

///////////////////////////////////////////////////////////////////////////////
//
//PUBLIC API
//
///////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns whether or not the response from the Firebase-client was successful.
	 *
	 * @return true if response from the Firebase-client was successful
	 */
	public boolean getSuccess() {
		return this.success;
	}

	/**
	 * Returns the HTTP status code returned from the Firebase-client.
	 *
	 * @return an integer representing an HTTP status code
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * Returns a map of the data returned by the Firebase-client.
	 *
	 * @return a map of Strings to Objects
	 */
	public Map<String, Object> getBody() {
		return this.body;
	}

	/**
	 * Returns the raw data response returned by the Firebase-client.
	 *
	 * @return a String of the JSON-response from the client
	 */
	public String getRawBody() {
		return this.rawBody;
	}

	/**
	 * Returns the response as a String
	 */
	@Override
	public String toString() {

		StringBuilder result = new StringBuilder();

		result.append(FirebaseResponse.class.getSimpleName() + "[ ").append("(Success:").append(this.success)
				.append(") ").append("(Code:").append(this.code).append(") ").append("(Body:").append(this.body)
				.append(") ").append("(Raw-body:").append(this.rawBody).append(") ").append("]");

		return result.toString();
	}

}