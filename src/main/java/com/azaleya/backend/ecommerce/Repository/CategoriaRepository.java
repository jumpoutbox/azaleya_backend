package com.azaleya.backend.ecommerce.Repository;

import com.azaleya.backend.ecommerce.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}
