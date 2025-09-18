package com.farmacia.farmacia.prescription.controller;

import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmacia.farmacia.prescription.dto.RecetaRequest;
import com.farmacia.farmacia.prescription.model.Receta;
import com.farmacia.farmacia.prescription.service.RecetaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recetas")
@RequiredArgsConstructor
public class RecetaController {
    private final RecetaService service;

    @PostMapping
    public ResponseEntity<Receta> crear(@Valid @RequestBody RecetaRequest dto) {
        return ResponseEntity.status(201).body(service.crear(dto));
    }

}
