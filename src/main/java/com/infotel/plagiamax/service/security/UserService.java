package com.infotel.plagiamax.service.security;

import com.infotel.plagiamax.model.User;

/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Saves a user.
	 *
	 * @param user the user
	 */
	void save(User user);

	/**
	 * Fins a user by his username.
	 *
	 * @param username the username
	 * @return the user
	 */
	User findByUsername(String username);
}
