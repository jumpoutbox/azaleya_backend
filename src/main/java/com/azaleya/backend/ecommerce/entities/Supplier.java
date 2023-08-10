package com.azaleya.backend.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.azaleya.backend.weddingPlanner.entites.UserRole;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tb_supplier")
public class Supplier implements UserDetails, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.UUID )
	private String id;

	private String nome;
	private String nif;
	private String email;
	private String password;
	private String imgPerfilUrl;
	private UserRole role;
	@OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Endereco> enderecos;

	public Supplier() {

	}
	public Supplier(String id, String nome, String nif, String email, String pass, String imgPerfilUrl) {
		this.id = id;
		this.nome = nome;
		this.nif = nif;
		this.email = email;
		this.password = password;
		this.imgPerfilUrl = imgPerfilUrl;
	}
	public Supplier(String id, String nome, String nif, String email, String password, String imgPerfilUrl, UserRole role) {
		this.id = id;
		this.nome = nome;
		this.nif = nif;
		this.email = email;
		this.password = password;
		this.imgPerfilUrl = imgPerfilUrl;
		this.role=role;
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
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImgPerfilUrl() {
		return imgPerfilUrl;
	}
	public void setImgPerfilUrl(String imgPerfilUrl) {
		this.imgPerfilUrl = imgPerfilUrl;
	}
	public Set<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.role == UserRole.ADMIN)
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
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
