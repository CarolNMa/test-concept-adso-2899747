package com.farmacia.farmacia.sales.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.sales.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
