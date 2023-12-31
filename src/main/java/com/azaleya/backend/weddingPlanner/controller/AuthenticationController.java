package com.azaleya.backend.weddingPlanner.controller;

import com.azaleya.backend.weddingPlanner.entites.Users;
import com.azaleya.backend.weddingPlanner.repository.UsersRepository;
import com.azaleya.backend.systemSecurity.TokenService;
import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.azaleya.backend.weddingPlanner.dto.AuthenticationDTO;
import com.azaleya.backend.weddingPlanner.dto.LoginResponseDTO;
import com.azaleya.backend.weddingPlanner.dto.RegisterDTO;
import com.azaleya.backend.weddingPlanner.entites.UserRole;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsersRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var emailPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(emailPassword);

        var token = tokenService.generateToken((Users)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users(data.id(),data.nome(),data.email(), data.telefone(), data.nome_parceiro(),encryptedPassword, UserRole.USER);

        this.repository.save(newUser);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).body(newUser);
    }

}
