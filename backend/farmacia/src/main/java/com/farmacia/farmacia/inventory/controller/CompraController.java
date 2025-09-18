package com.farmacia.farmacia.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmacia.farmacia.inventory.dto.CompraRequest;
import com.farmacia.farmacia.inventory.model.Compra;
import com.farmacia.farmacia.inventory.service.CompraService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/compras")
@RequiredArgsConstructor
public class CompraController {
    private final CompraService service;

    @GetMapping
    public List<Compra> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Compra buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public ResponseEntity<Compra> registrar(@Valid @RequestBody CompraRequest dto) {
        return ResponseEntity.status(201).body(service.registrarCompra(dto));
    }
}
