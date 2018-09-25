package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface UserCrudRepository. Persists the User class inside of the
 * database
 */
@Repository
public interface UserCrudRepository extends IBaseRepository<User, Long> {

	/**
	 * Finds a user with his username.
	 *
	 * @param username : the username
	 * @return the user
	 */
	User findByUsername(String username);

	/**
	 * Finds a user with his username and password.
	 *
	 * @param username : the username
	 * @param password : the password
	 * @return the user
	 */
	User findByUsernameAndPassword(String username, String password);

}
