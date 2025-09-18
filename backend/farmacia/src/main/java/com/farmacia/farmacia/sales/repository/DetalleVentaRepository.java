package com.farmacia.farmacia.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.sales.model.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
}
