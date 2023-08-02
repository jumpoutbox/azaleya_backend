package com.azaleya.backend.ecommerce.dto;

import com.azaleya.backend.ecommerce.entities.Endereco;
import com.azaleya.backend.ecommerce.entities.Supplier;

public class EnderecoDTO {
	private Long id;

	private String endereco;
	private int telefone;
	private String provincia;

	private Supplier supplier;

	public EnderecoDTO() {

	}

	public EnderecoDTO(Long id, String endereco, int telefone, String provincia, Supplier supplier) {
		this.id = id;
		this.endereco = endereco;
		this.telefone = telefone;
		this.provincia = provincia;
		this.supplier = supplier;
	}

	public EnderecoDTO(Endereco endereco) {
		this.id = endereco.getId();
		this.endereco = endereco.getEndereco();
		this.telefone = endereco.getTelefone();
		this.provincia = endereco.getProvincia();
		this.supplier = endereco.getSupplier();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
