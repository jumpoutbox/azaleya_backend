package com.azaleya.backend.weddingPlanner.dto;

import com.azaleya.backend.weddingPlanner.entites.Guest;
import com.azaleya.backend.weddingPlanner.entites.Mesas;

public class GuestDTO {
	private String id;
	private String name;
	private Boolean confirmation;
	private MesasDTO mesa;

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

	public GuestDTO(Guest guest, Mesas mesa) {
		this(guest);
		this.mesa = new MesasDTO(mesa);
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

	public MesasDTO getMesa() {
		return mesa;
	}

	public void setMesa(MesasDTO mesa) {
		this.mesa = mesa;
	}
}
