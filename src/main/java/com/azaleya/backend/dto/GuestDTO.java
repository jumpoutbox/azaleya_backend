package com.azaleya.backend.dto;

import com.azaleya.backend.entites.Guest;

public class GuestDTO {
	private String id;
	private String name;
	private Boolean confirmation;

	public GuestDTO() {

	}

	public GuestDTO(Guest guest) {
		this.id=guest.getId();
		this.name=guest.getName();
		this.confirmation=guest.getConfirmation();
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
