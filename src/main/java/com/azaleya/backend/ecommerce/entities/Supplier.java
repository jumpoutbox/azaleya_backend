package com.azaleya.backend.ecommerce.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_supplier")
public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO )
	private Long id;
	
	private String nome;
	private String nif;
	private String email;
	private String pass;
	private String imgPerfilUrl;
	@OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Endereco> enderecos;
	
	public Supplier() {
		
	}
	public Supplier(Long id, String nome, String nif, String email, String pass, String imgPerfilUrl) {
		this.id = id;
		this.nome = nome;
		this.nif = nif;
		this.email = email;
		this.pass = pass;
		this.imgPerfilUrl = imgPerfilUrl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	
	
}
