package com.azaleya.backend.weddingPlanner.entites;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_guest")
public class Guest implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID )
	private String id;

	@ManyToOne
	@JoinColumn(name="mesa_id")
	private Mesas mesa;

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

	public Mesas getMesa() {
		return mesa;
	}

	public void setMesa(Mesas mesa) {
		this.mesa = mesa;
	}
}
