package com.farmacia.farmacia.inventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.inventory.model.DetalleCompra;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {
}
