package com.farmacia.farmacia.inventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.inventory.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
