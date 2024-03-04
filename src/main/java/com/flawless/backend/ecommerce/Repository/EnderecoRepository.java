package com.flawless.backend.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flawless.backend.ecommerce.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String>{

}
