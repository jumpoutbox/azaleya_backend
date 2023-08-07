package com.azaleya.backend.ecommerce.dto;

import com.azaleya.backend.ecommerce.entities.Categoria;
import com.azaleya.backend.ecommerce.entities.Images;
import com.azaleya.backend.ecommerce.entities.Produtos;

public class ProdutoDTO {
    private String id;
    private String nome;
    private String descricao;
    private Double preco;

    private CategoriaDTO categoriaDTO;
    private ImagesDTO imagesDTO;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String id, String nome, String descricao, Double preco, CategoriaDTO categoriaDTO, ImagesDTO imagesDTO) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoriaDTO = categoriaDTO;
        this.imagesDTO = imagesDTO;
    }
    public ProdutoDTO(Produtos produtos) {
        this.id = produtos.getId();
        this.nome = produtos.getNome();
        this.descricao = produtos.getDescricao();
        this.preco = produtos.getPreco();
    }
    public ProdutoDTO(Produtos produtos, Categoria categoria, Images images) {
        this(produtos);
        this.categoriaDTO=new CategoriaDTO(categoria);
        this.imagesDTO=new ImagesDTO(images);
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public CategoriaDTO getCategoriaDTO() {
        return categoriaDTO;
    }

    public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
        this.categoriaDTO = categoriaDTO;
    }

    public ImagesDTO getImagesDTO() {
        return imagesDTO;
    }

    public void setImagesDTO(ImagesDTO imagesDTO) {
        this.imagesDTO = imagesDTO;
    }
}
