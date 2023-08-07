package com.azaleya.backend.ecommerce.Repository;

import com.azaleya.backend.ecommerce.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, String> {
}
