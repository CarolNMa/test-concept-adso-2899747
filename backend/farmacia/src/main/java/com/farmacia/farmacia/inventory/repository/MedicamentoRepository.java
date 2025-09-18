package com.farmacia.farmacia.inventory.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.inventory.model.Medicamento;

import java.util.Optional;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    Optional<Medicamento> findByNombreIgnoreCase(String nombre);
}
