package com.azaleya.backend.dto;

public class GuestDTO {
	private Long id;
	private String name;
	private Boolean confirmation;

	public GuestDTO() {

	}

	public GuestDTO(Long id, String name, Boolean confirmation) {
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
