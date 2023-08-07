package com.azaleya.backend.ecommerce.dto;

import com.azaleya.backend.ecommerce.entities.Categoria;
import com.azaleya.backend.ecommerce.entities.Produtos;

import java.util.Set;

public class CategoriaDTO {
    private String id;
    private String nome;
    private String descricacao;
    private Set<Produtos> produtos;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria){
        this.id=categoria.getId();
        this.nome=categoria.getNome();
        this.descricacao=categoria.getDescricacao();
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

    public String getDescricacao() {
        return descricacao;
    }

    public void setDescricacao(String descricacao) {
        this.descricacao = descricacao;
    }

    public Set<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produtos> produtos) {
        this.produtos = produtos;
    }
}
