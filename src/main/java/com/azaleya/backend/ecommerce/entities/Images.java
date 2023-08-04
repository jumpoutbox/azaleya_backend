package com.azaleya.backend.ecommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_images")
public class Images {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String url;

    public Images() {
    }

    public Images(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
