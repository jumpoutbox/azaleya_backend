package com.flawless.backend.weddingPlanner.dto;

import com.flawless.backend.weddingPlanner.entites.UserRole;

import jakarta.validation.constraints.Email;

public record RegisterDTO (String id, String nome,
		@Email(message="Por favor insira um email válido")
		String email,
		int telefone,
		String nome_parceiro,
		String password,
		UserRole role){
}
