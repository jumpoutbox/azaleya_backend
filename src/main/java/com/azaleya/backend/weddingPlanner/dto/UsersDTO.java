package com.azaleya.backend.weddingPlanner.dto;

import com.azaleya.backend.weddingPlanner.entites.Budget;
import com.azaleya.backend.weddingPlanner.entites.CheckList;
import com.azaleya.backend.weddingPlanner.entites.Users;

import java.util.HashSet;
import java.util.Set;

public class UsersDTO {
	private String id;

	private String nome;
	private String email;
	private int telefone;
	private String nome_parceiro;

	private Set<CheckList> toDoList = new HashSet<>();

	private Budget budget;

	public UsersDTO() {

	}

	public UsersDTO(String id, String nome, String email, int telefone, String nome_parceiro) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.nome_parceiro = nome_parceiro;
	}

	public UsersDTO(Users users) {
		this.id = users.getId();
		this.nome = users.getNome();
		this.email = users.getEmail();
		this.telefone = users.getTelefone();
		this.nome_parceiro = users.getNome_parceiro();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Set<CheckList> getToDoList() {
		return toDoList;
	}

	public void setToDoList(Set<CheckList> toDoList) {
		this.toDoList = toDoList;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}
}
