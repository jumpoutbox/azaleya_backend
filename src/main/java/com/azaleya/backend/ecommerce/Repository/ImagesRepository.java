package com.azaleya.backend.ecommerce.Repository;

import com.azaleya.backend.ecommerce.entities.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<Images, String> {
}
