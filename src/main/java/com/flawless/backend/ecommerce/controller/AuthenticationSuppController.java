package com.flawless.backend.ecommerce.controller;

import com.flawless.backend.ecommerce.Repository.SupplierRepository;
import com.flawless.backend.ecommerce.dto.AuthenticationSuppDTO;
import com.flawless.backend.ecommerce.dto.RegisterSuppDTO;
import com.flawless.backend.ecommerce.entities.Supplier;
import com.flawless.backend.systemSecurity.TokenService;
import com.flawless.backend.weddingPlanner.dto.LoginResponseDTO;
import com.flawless.backend.weddingPlanner.entites.UserRole;
import jakarta.validation.Valid;
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

import java.net.URI;

@RestController
@RequestMapping("authSupp")
public class AuthenticationSuppController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SupplierRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationSuppDTO data){
        var emailPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(emailPassword);

        var token = tokenService.generateTokenSup((Supplier)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterSuppDTO data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Supplier newUser = new Supplier(data.id(),data.nome(), data.nif(),data.email(), encryptedPassword, data.imgPefilUrl(), UserRole.USER);

        this.repository.save(newUser);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }
}
