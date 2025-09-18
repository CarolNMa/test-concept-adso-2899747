package com.farmacia.farmacia.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmacia.farmacia.inventory.dto.LoteRequest;
import com.farmacia.farmacia.inventory.model.Lote;
import com.farmacia.farmacia.inventory.model.Medicamento;
import com.farmacia.farmacia.inventory.repository.LoteRepository;
import com.farmacia.farmacia.inventory.repository.MedicamentoRepository;
import com.farmacia.farmacia.shared.exception.BusinessException;
import com.farmacia.farmacia.shared.exception.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoteService {
    private final LoteRepository repo;
    private final MedicamentoRepository medRepo;

    @Transactional
    public Lote crear(LoteRequest dto) {
        Medicamento med = medRepo.findById(dto.getMedicamentoId())
                .orElseThrow(() -> new NotFoundException("Medicamento no encontrado"));

        Lote lote = new Lote();
        lote.setMedicamento(med);
        lote.setNroLote(dto.getNroLote());
        lote.setFechaVencimiento(dto.getFechaVencimiento());
        lote.setStock(dto.getStock());
        return repo.save(lote);
    }

    public List<Lote> obtenerPorMedicamento(Long medicamentoId) {
        return repo.findByMedicamentoIdAndStockGreaterThanOrderByFechaVencimientoAsc(medicamentoId, 0);
    }

    public void verificarStock(Long medicamentoId, int cantidad) {
        int disponible = obtenerPorMedicamento(medicamentoId).stream()
                .mapToInt(Lote::getStock).sum();
        if (disponible < cantidad) {
            throw new BusinessException("Stock insuficiente para medicamento id=" + medicamentoId);
        }
    }

    @Transactional
    public void descontarStock(Long medicamentoId, int cantidad) {
        var lotes = obtenerPorMedicamento(medicamentoId);
        int restante = cantidad;
        for (Lote lote : lotes) {
            if (restante == 0)
                break;
            int usar = Math.min(lote.getStock(), restante);
            lote.setStock(lote.getStock() - usar);
            restante -= usar;
        }
        if (restante > 0)
            throw new BusinessException("No fue posible descontar todo el stock.");
    }
}
