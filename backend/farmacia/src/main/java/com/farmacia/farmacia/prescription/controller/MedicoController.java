package com.farmacia.farmacia.prescription.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmacia.farmacia.prescription.dto.MedicoRequest;
import com.farmacia.farmacia.prescription.model.Medico;
import com.farmacia.farmacia.prescription.service.MedicoService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@RequiredArgsConstructor
public class MedicoController {
    private final MedicoService service;

    @GetMapping
    public List<Medico> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Medico buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public ResponseEntity<Medico> crear(@Valid @RequestBody MedicoRequest dto) {
        return ResponseEntity.status(201).body(service.crear(dto));
    }
}
