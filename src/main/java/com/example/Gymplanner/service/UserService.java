package com.example.Gymplanner.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.Gymplanner.domain.User;
import com.example.Gymplanner.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    User save(UserRegistrationDto registration);
}