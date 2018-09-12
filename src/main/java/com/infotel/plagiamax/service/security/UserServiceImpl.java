package com.infotel.plagiamax.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.plagiamax.model.security.SecurityRole;
import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.repository.UserCrudRepository;
import com.infotel.plagiamax.repository.security.SecurityRoleCrudRepository;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserCrudRepository userRepository;
    @Autowired
    private SecurityRoleCrudRepository roleRepository;

    public void save(User user) {
        user.setPassword(user.getPassword());
        user.setRoles((Set<SecurityRole>)roleRepository.findAll());
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
