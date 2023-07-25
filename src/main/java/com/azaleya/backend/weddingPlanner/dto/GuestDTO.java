package com.azaleya.backend.weddingPlanner.dto;

import com.azaleya.backend.weddingPlanner.entites.Guest;

public class GuestDTO {
	private String id;
	private String name;
	private Boolean confirmation;

	public GuestDTO() {

	}

	public GuestDTO(String id, String name, Boolean confirmation) {
		this.id = id;
		this.name = name;
		this.confirmation = confirmation;
	}

	public GuestDTO(Guest guest) {
		id=guest.getId();
		name=guest.getName();
		confirmation=guest.getConfirmation();
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
