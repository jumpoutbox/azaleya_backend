package com.azaleya.backend.ecommerce.dto;

import com.azaleya.backend.ecommerce.entities.Categoria;

public class CategoriaDTO {
    private String id;
    private String nome;
    private String descricacao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(String id, String nome, String descricacao) {
        this.id = id;
        this.nome = nome;
        this.descricacao = descricacao;
    }

    public CategoriaDTO(Categoria categoria){
        this.id=categoria.getId();
        this.nome=categoria.getNome();
        this.descricacao=categoria.getDescricacao();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricacao() {
        return descricacao;
    }
}
