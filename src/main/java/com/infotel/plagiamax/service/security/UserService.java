package com.infotel.plagiamax.service.security;

import com.infotel.plagiamax.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
