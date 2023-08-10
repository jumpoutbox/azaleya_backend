package com.azaleya.backend.ecommerce.dto;

import com.azaleya.backend.weddingPlanner.entites.UserRole;
import jakarta.validation.constraints.Email;

public record RegisterSuppDTO(String id, String nome, @Email(message="Por favor insira um email válido") String email, String nif, String password, String imgPefilUrl, UserRole role) {
}
