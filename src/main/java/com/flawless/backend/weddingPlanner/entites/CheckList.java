package com.flawless.backend.weddingPlanner.entites;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_checklist")
@EqualsAndHashCode(of = "id")
public class CheckList implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String toDo;
	@Column(columnDefinition = "TEXT")
	private String description;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant tillDate;
	private Boolean done;

	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Users user;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_checklist_chklstcategory",
			joinColumns = @JoinColumn(name="checklist_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<CheckListCategory> categoria = new HashSet<>();

	public CheckList(){}

	public CheckList(String id, String toDo, String description, Instant tillDate, Boolean done, Users user, Set<CheckListCategory> categoria) {
		this.id = id;
		this.toDo = toDo;
		this.description = description;
		this.tillDate = tillDate;
		this.done = done;
		this.user = user;
		this.categoria = categoria;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Set<CheckListCategory> getCategoria() {
		return categoria;
	}

	public void setCategoria(Set<CheckListCategory> categoria) {
		this.categoria = categoria;
	}
}
