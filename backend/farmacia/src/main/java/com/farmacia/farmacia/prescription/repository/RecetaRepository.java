package com.farmacia.farmacia.prescription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.prescription.model.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
}
