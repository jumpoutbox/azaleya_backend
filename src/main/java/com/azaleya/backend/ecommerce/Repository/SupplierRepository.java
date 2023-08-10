package com.azaleya.backend.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azaleya.backend.ecommerce.entities.Supplier;
import org.springframework.security.core.userdetails.UserDetails;

public interface SupplierRepository extends JpaRepository<Supplier, String> {
    UserDetails findByEmail(String email);
}
