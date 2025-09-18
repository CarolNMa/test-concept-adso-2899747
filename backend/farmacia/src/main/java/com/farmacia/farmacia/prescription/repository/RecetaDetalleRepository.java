package com.farmacia.farmacia.prescription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.prescription.model.RecetaDetalle;

public interface RecetaDetalleRepository extends JpaRepository<RecetaDetalle, Long> {
}
