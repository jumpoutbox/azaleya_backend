package com.azaleya.backend.ecommerce.dto;

import com.azaleya.backend.ecommerce.entities.Images;

import java.util.Set;

public class ImagesDTO {
    private String id;
    private String url;

    private Set<ProdutoDTO> produtoDTO;

    public ImagesDTO() {
    }

    public ImagesDTO(String id, String url) {
        this.id = id;
        this.url = url;
    }
    public ImagesDTO(Images images) {
        this.id = images.getId();
        this.url = images.getUrl();
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Set<ProdutoDTO> getProdutoDTO() {
        return produtoDTO;
    }
}
