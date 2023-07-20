package com.azaleya.backend.weddingPlanner.entites;

import java.io.Serializable;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_user")
public class Users implements UserDetails, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID )
	private String id;

	private String nome;

	@Column(unique = true)
	private String email;

	private String password;

	private UserRole role;

	private int telefone;
	private String nome_parceiro;

	@OneToMany(mappedBy="user")
	private Set<CheckList> toDoList = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "budget_id", referencedColumnName = "id")
	private Budget budget;

	public Users() {

	}
	public Users(String id, String nome, String email, int telefone, String nome_parceiro, String password ) {
		this.id=id;
		this.nome=nome;
		this.email=email;
		this.telefone=telefone;
		this.nome_parceiro=nome_parceiro;
		this.password = password;
	}
	public Users(String id, String nome, String email, int telefone, String nome_parceiro, String password, UserRole role) {
		this.id=id;
		this.nome=nome;
		this.email=email;
		this.telefone=telefone;
		this.nome_parceiro=nome_parceiro;
		this.password = password;
		this.role = role;
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

	public Set<CheckList> getToDoList() {
		return toDoList;
	}

	public void setToDoList(Set<CheckList> toDoList) {
		this.toDoList = toDoList;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
