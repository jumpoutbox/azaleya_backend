package com.flawless.backend.weddingPlanner.services;

import com.flawless.backend.weddingPlanner.entites.Users;
import com.flawless.backend.weddingPlanner.repository.UsersRepository;
import com.flawless.backend.weddingPlanner.services.exception.ForbiddenException;
import com.flawless.backend.weddingPlanner.services.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UsersRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public Users authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return (Users) repository.findByEmail(username);
        }
        catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateSelfOrAdmin(String userId) {
        Users user = authenticated();
        if (!user.getId().equals(userId) && !user.hasHole("admin")) {
            throw new ForbiddenException("Access denied");
        }
    }

}
