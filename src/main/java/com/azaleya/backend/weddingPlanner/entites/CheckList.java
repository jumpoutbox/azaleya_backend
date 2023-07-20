package com.azaleya.backend.weddingPlanner.entites;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_checklist")
public class CheckList implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String toDo;
	private Instant tillDate;
	private Boolean done;

	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Users user;

	public CheckList() {
	}

	public CheckList(String id, String toDo, Instant tillDate, Boolean done, Users user) {
		super();
		this.id = id;
		this.toDo = toDo;
		this.tillDate = tillDate;
		this.done = done;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToDo() {
		return toDo;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

	public Instant getTillDate() {
		return tillDate;
	}

	public void setTillDate(Instant tillDate) {
		this.tillDate = tillDate;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
