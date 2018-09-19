package com.infotel.plagiamax.service.security;

// TODO: Auto-generated Javadoc
/**
 * The Interface SecurityService.
 */
public interface SecurityService {
    
    /**
     * Find logged in username.
     *
     * @return the string
     */
    String findLoggedInUsername();

    /**
     * Autologin.
     *
     * @param username the username
     * @param password the password
     */
    void autologin(String username, String password);
}
