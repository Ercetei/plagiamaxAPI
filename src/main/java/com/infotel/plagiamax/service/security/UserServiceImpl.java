package com.infotel.plagiamax.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.plagiamax.model.security.SecurityRole;
import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.repository.UserCrudRepository;
import com.infotel.plagiamax.repository.security.SecurityRoleCrudRepository;

import java.util.Set;

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

    /** 
     * implements the save operation of the class userService
     */
    public void save(User user) {
        user.setPassword(user.getPassword());
        user.setRoles((Set<SecurityRole>)roleRepository.findAll());
        userRepository.save(user);
    }

    /** 
     * implements the findByUsername operation of the class userService
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
