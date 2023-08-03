package com.azaleya.backend.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azaleya.backend.ecommerce.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String> {

}
