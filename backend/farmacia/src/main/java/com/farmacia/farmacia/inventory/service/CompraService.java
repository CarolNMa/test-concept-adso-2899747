package com.farmacia.farmacia.inventory.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmacia.farmacia.inventory.dto.CompraItemRequest;
import com.farmacia.farmacia.inventory.dto.CompraRequest;
import com.farmacia.farmacia.inventory.dto.LoteRequest;
import com.farmacia.farmacia.inventory.model.Compra;
import com.farmacia.farmacia.inventory.model.DetalleCompra;
import com.farmacia.farmacia.inventory.model.Medicamento;
import com.farmacia.farmacia.inventory.model.Proveedor;
import com.farmacia.farmacia.inventory.repository.CompraRepository;
import com.farmacia.farmacia.inventory.repository.DetalleCompraRepository;
import com.farmacia.farmacia.inventory.repository.MedicamentoRepository;
import com.farmacia.farmacia.inventory.repository.ProveedorRepository;
import com.farmacia.farmacia.shared.exception.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {
    private final CompraRepository compraRepo;
    private final DetalleCompraRepository detalleRepo;
    private final ProveedorRepository proveedorRepo;
    private final MedicamentoRepository medRepo;
    private final LoteService loteService;

    public List<Compra> listar() {
        return compraRepo.findAll();
    }

    public Compra buscar(Long id) {
        return compraRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Compra no encontrada"));
    }

    @Transactional
    public Compra registrarCompra(CompraRequest dto) {
        Proveedor proveedor = proveedorRepo.findById(dto.getProveedorId())
                .orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));

        Compra compra = new Compra();
        compra.setProveedor(proveedor);
        compra.setFecha(dto.getFecha());
        compra.setTotal(dto.getTotal());
        compra = compraRepo.save(compra);

        for (CompraItemRequest it : dto.getItems()) {
            Medicamento med = medRepo.findById(it.getMedicamentoId())
                    .orElseThrow(() -> new NotFoundException("Medicamento no encontrado"));

            DetalleCompra d = new DetalleCompra();
            d.setCompra(compra);
            d.setMedicamento(med);
            d.setCantidad(it.getCantidad());
            d.setCostoUnitario(it.getCostoUnitario());
            detalleRepo.save(d);

           
            loteService.crear(new LoteRequest() {
                {
                    setMedicamentoId(med.getId());
                    setNroLote("AUTO-" + System.currentTimeMillis());
                    setFechaVencimiento(java.time.LocalDate.now().plusYears(2)); // se puede parametrizar
                    setStock(it.getCantidad());
                }
            });
        }

        return compra;
    }
}
