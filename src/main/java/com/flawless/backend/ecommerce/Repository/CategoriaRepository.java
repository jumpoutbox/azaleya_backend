package com.flawless.backend.ecommerce.Repository;

import com.flawless.backend.ecommerce.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}
