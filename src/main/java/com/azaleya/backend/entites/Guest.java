package com.azaleya.backend.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	private String name;
	private Boolean confirmation;
	
	public Guest() {
		
	}
	public Guest(Long id, String name, Boolean confirmation) {
		this.id=id;
		this.name=name;
		this.confirmation=confirmation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
