package com.azaleya.backend.ecommerce.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    private String descricacao;

    @OneToMany(mappedBy = "categoria",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Produtos> produtos;

    public Categoria() {
    }

    public Categoria(String id, String nome, String descricacao) {
        this.id = id;
        this.nome = nome;
        this.descricacao = descricacao;
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
