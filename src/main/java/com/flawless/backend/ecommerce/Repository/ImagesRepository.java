package com.flawless.backend.ecommerce.Repository;

import com.flawless.backend.ecommerce.entities.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<Images, String> {
}
