package com.flawless.backend.weddingPlanner.dto;

import com.flawless.backend.weddingPlanner.entites.Budget;
import com.flawless.backend.weddingPlanner.entites.CheckList;
import com.flawless.backend.weddingPlanner.entites.InfoDetails;
import com.flawless.backend.weddingPlanner.entites.Users;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsersDTO {
	private String id;
	private String nome;
	private String email;
	private int telefone;
	private String nome_parceiro;
	private Set<CheckListDTO> toDoList = new HashSet<>();
	private BudgetDTO budget;
	private InfoDetailsDTO infoDetails;

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
		this.budget = new BudgetDTO(users.getBudget());
		this.infoDetails = new InfoDetailsDTO(users.getInfoDetails());
	}
	public UsersDTO(Users entity, List<CheckList> todos, Budget budget1, InfoDetails info) {
		this(entity);
		todos.forEach(todo -> this.toDoList.add(new CheckListDTO(todo)));
		new BudgetDTO(budget1);
		new InfoDetailsDTO(info);
	}
	public UsersDTO(Users entity, List<CheckList> todos, Budget budget1) {
		this(entity);
		todos.forEach(todo -> this.toDoList.add(new CheckListDTO(todo)));
		new BudgetDTO(budget1);
	}
	public UsersDTO(Users entity, List<CheckList> todos, InfoDetails info) {
		this(entity);
		todos.forEach(todo -> this.toDoList.add(new CheckListDTO(todo)));
		new InfoDetailsDTO(info);
	}

	public UsersDTO(Users entity, List<CheckList> todos) {
		this(entity);
		todos.forEach(todo -> this.toDoList.add(new CheckListDTO(todo)));
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

	public Set<CheckListDTO> getToDoList() {
		return toDoList;
	}

	public void setToDoList(Set<CheckListDTO> toDoList) {
		this.toDoList = toDoList;
	}

	public BudgetDTO getBudget() {
		return budget;
	}

	public void setBudgetDTO(BudgetDTO budget) {
		this.budget = budget;
	}

	public InfoDetailsDTO getInfoDetails() {
		return infoDetails;
	}

	public void setInfoDetails(InfoDetailsDTO infoDetails) {
		this.infoDetails = infoDetails;
	}
}
