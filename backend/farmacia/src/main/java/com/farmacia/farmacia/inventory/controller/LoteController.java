package com.farmacia.farmacia.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmacia.farmacia.inventory.dto.LoteRequest;
import com.farmacia.farmacia.inventory.model.Lote;
import com.farmacia.farmacia.inventory.service.LoteService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/lotes")
@RequiredArgsConstructor
public class LoteController {
    private final LoteService service;

    @PostMapping
    public ResponseEntity<Lote> crear(@Valid @RequestBody LoteRequest dto) {
        return ResponseEntity.status(201).body(service.crear(dto));
    }

    @GetMapping("/medicamento/{id}")
    public List<Lote> obtenerPorMedicamento(@PathVariable Long id) {
        return service.obtenerPorMedicamento(id);
    }
}
