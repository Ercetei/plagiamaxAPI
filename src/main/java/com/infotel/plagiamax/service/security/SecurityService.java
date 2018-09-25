package com.infotel.plagiamax.service.security;

/**
 * The Interface SecurityService.
 */
public interface SecurityService {

	/**
	 * Finds the username for the User logged in
	 *
	 * @return the string
	 */
	String findLoggedInUsername();

	/**
	 * Logs the user if he was connected before closing the application
	 *
	 * @param username the username
	 * @param password the password
	 */
	void autologin(String username, String password);
}
