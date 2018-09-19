package com.infotel.plagiamax.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityServiceImpl.
 */
@Service
public class SecurityServiceImpl implements SecurityService{
    
    /** The authentication manager. */
    @Autowired
    private AuthenticationManager authenticationManager;

    /** The user details service. */
    @Autowired
    private UserDetailsService userDetailsService;

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    /* (non-Javadoc)
     * @see com.infotel.plagiamax.service.security.SecurityService#findLoggedInUsername()
     */
    public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
      if (userDetails instanceof UserDetails) {
          return ((UserDetails)userDetails).getUsername();
      }
      return null;
	}

    /* (non-Javadoc)
     * @see com.infotel.plagiamax.service.security.SecurityService#autologin(java.lang.String, java.lang.String)
     */
    public void autologin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", username));
        }
    }
}
