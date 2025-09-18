package com.farmacia.farmacia.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.inventory.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

}
