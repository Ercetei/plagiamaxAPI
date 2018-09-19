package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.repository.base.IBaseRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserCrudRepository.
 */
@Repository
public interface UserCrudRepository extends IBaseRepository<User, Long>{
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the user
	 */
	User findByUsername(String username);
	
	/**
	 * Find by username and password.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user
	 */
	User findByUsernameAndPassword(String username, String password);

}
