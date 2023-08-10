package com.azaleya.backend.ecommerce.dto;

import java.util.Set;

import com.azaleya.backend.ecommerce.entities.Endereco;
import com.azaleya.backend.ecommerce.entities.Supplier;

public class SupplierDTO {
	private String id;
	private String nome;
	private String nif;
	private String email;
	private String pass;
	private String imgPerfilUrl;
	private Set<Endereco> enderecos;


	public SupplierDTO() {

	}

	public SupplierDTO(Supplier entity) {
		this.id=entity.getId();
		this.nome=entity.getNome();
		this.nif=entity.getNif();
		this.email=entity.getEmail();
		this.pass=entity.getPassword();
		this.imgPerfilUrl=entity.getImgPerfilUrl();
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
