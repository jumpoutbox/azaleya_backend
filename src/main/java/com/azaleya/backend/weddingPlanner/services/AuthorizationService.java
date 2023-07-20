package com.azaleya.backend.weddingPlanner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.azaleya.backend.weddingPlanner.repository.UsersRepository;


@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UsersRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email);
    }
}
