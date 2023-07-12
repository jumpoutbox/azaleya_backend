package com.azaleya.backend.dto;

public class UsersDTO {
private Long id;
	
	private String nome;
	private String email;
	private int telefone;
	private String nome_parceiro;
	
public UsersDTO() {
		
	}
	public UsersDTO(Long id, String nome, String email, int telefone, String nome_parceiro ) {
		this.id=id;
		this.nome=nome;
		this.email=email;
		this.telefone=telefone;
		this.nome_parceiro=nome_parceiro;
	}
}
