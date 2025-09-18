package com.farmacia.farmacia.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmacia.farmacia.inventory.dto.MedicamentoRequest;
import com.farmacia.farmacia.inventory.model.Medicamento;
import com.farmacia.farmacia.inventory.service.MedicamentoService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {
    private final MedicamentoService service;

    @GetMapping
    public List<Medicamento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Medicamento buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Medicamento> crear(@Valid @RequestBody MedicamentoRequest dto) {
        return ResponseEntity.status(201).body(service.crear(dto));
    }

    @PutMapping("/{id}")
    public Medicamento actualizar(@PathVariable Long id, @Valid @RequestBody MedicamentoRequest dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
