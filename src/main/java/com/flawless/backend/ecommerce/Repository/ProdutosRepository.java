package com.flawless.backend.ecommerce.Repository;

import com.flawless.backend.ecommerce.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, String> {
}
