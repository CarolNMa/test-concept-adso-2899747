package com.farmacia.farmacia.inventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.inventory.model.Lote;

import java.util.List;

public interface LoteRepository extends JpaRepository<Lote, Long> {
    List<Lote> findByMedicamentoIdAndStockGreaterThanOrderByFechaVencimientoAsc(Long medicamentoId, int stock);
}
