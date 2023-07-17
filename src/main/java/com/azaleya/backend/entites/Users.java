package com.azaleya.backend.entites;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;

	private String nome;
	private String email;
	private int telefone;
	private String nome_parceiro;

	public Users() {

	}
	public Users(Long id, String nome, String email, int telefone, String nome_parceiro ) {
		this.id=id;
		this.nome=nome;
		this.email=email;
		this.telefone=telefone;
		this.nome_parceiro=nome_parceiro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getNome_parceiro() {
		return nome_parceiro;
	}
	public void setNome_parceiro(String nome_parceiro) {
		this.nome_parceiro = nome_parceiro;
	}


}
