package com.farmacia.farmacia.sales.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmacia.farmacia.inventory.model.Medicamento;
import com.farmacia.farmacia.inventory.repository.MedicamentoRepository;
import com.farmacia.farmacia.inventory.service.LoteService;
import com.farmacia.farmacia.prescription.model.Receta;
import com.farmacia.farmacia.prescription.repository.RecetaRepository;
import com.farmacia.farmacia.sales.dto.VentaRequest;
import com.farmacia.farmacia.sales.model.DetalleVenta;
import com.farmacia.farmacia.sales.model.Venta;
import com.farmacia.farmacia.sales.repository.DetalleVentaRepository;
import com.farmacia.farmacia.sales.repository.VentaRepository;
import com.farmacia.farmacia.shared.exception.NotFoundException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VentaService {
    private final VentaRepository ventaRepo;
    private final DetalleVentaRepository detalleRepo;
    private final RecetaRepository recetaRepo;
    private final MedicamentoRepository medRepo;
    private final LoteService loteService;

    @Transactional
    public Long crearVenta(VentaRequest dto) {
        Receta receta = null;
        if (dto.getRecetaId() != null) {
            receta = recetaRepo.findById(dto.getRecetaId())
                    .orElseThrow(() -> new NotFoundException("Receta no encontrada"));
        }

        // Verificar stock
        dto.getItems().forEach(it -> loteService.verificarStock(it.getMedicamentoId(), it.getCantidad()));

        Venta venta = new Venta();
        venta.setFecha(LocalDateTime.now());
        venta.setReceta(receta);
        venta.setTotal(0.0);
        venta = ventaRepo.save(venta);

        double total = 0.0;
        for (var it : dto.getItems()) {
            Medicamento med = medRepo.findById(it.getMedicamentoId())
                    .orElseThrow(() -> new NotFoundException("Medicamento no encontrado"));

            // Descontar stock por FEFO
            loteService.descontarStock(med.getId(), it.getCantidad());

            DetalleVenta d = new DetalleVenta();
            d.setVenta(venta);
            d.setMedicamento(med);
            d.setCantidad(it.getCantidad());
            d.setPrecioUnitario(med.getPrecio());
            detalleRepo.save(d);

            total += med.getPrecio() * it.getCantidad();
        }

        venta.setTotal(total);
        ventaRepo.save(venta);
        return venta.getId();
    }
}
