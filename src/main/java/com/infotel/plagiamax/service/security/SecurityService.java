package com.infotel.plagiamax.service.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
