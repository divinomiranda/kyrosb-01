package com.kyros.divino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyros.divino.model.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {

}
