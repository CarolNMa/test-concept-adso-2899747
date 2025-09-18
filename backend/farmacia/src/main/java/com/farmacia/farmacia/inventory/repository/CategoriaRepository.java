package com.farmacia.farmacia.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.inventory.model.Categoria;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNombreIgnoreCase(String nombre);
}
