package com.farmacia.farmacia.sales.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmacia.farmacia.sales.dto.VentaRequest;
import com.farmacia.farmacia.sales.service.VentaService;

import jakarta.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {
    private final VentaService service;

    @PostMapping
    public ResponseEntity<Map<String, Object>> crear(@Valid @RequestBody VentaRequest dto) {
        Long id = service.crearVenta(dto);
        return ResponseEntity.status(201).body(Map.of("idVenta", id));
    }
}
