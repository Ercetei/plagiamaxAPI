package com.infotel.plagiamax.service.security;

import com.infotel.plagiamax.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {
    
    /**
     * Save.
     *
     * @param user the user
     */
    void save(User user);

    /**
     * Find by username.
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);
}
