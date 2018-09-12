package com.infotel.plagiamax.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.plagiamax.model.security.SecurityRole;
import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.repository.UserCrudRepository;
import com.infotel.plagiamax.repository.security.SecurityRoleCrudRepository;

import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {
    
    /** The user repository. */
    @Autowired
    private UserCrudRepository userRepository;
    
    /** The role repository. */
    @Autowired
    private SecurityRoleCrudRepository roleRepository;

    /* (non-Javadoc)
     * @see com.infotel.plagiamax.service.security.UserService#save(com.infotel.plagiamax.model.User)
     */
    public void save(User user) {
        user.setPassword(user.getPassword());
        user.setRoles((Set<SecurityRole>)roleRepository.findAll());
        userRepository.save(user);
    }

    /* (non-Javadoc)
     * @see com.infotel.plagiamax.service.security.UserService#findByUsername(java.lang.String)
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
