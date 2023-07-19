package com.azaleya.backend.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_guest")
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID )
	private String id;

	private String name;
	private Boolean confirmation;

	public Guest() {

	}
	public Guest(String id, String name, Boolean confirmation) {
		this.id=id;
		this.name=name;
		this.confirmation=confirmation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(Boolean confirmation) {
		this.confirmation = confirmation;
	}


}
