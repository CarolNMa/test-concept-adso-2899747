package com.farmacia.farmacia.prescription.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmacia.farmacia.prescription.dto.PacienteRequest;
import com.farmacia.farmacia.prescription.model.Paciente;
import com.farmacia.farmacia.prescription.service.PacienteService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {
    private final PacienteService service;

    @GetMapping
    public List<Paciente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Paciente buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public ResponseEntity<Paciente> crear(@Valid @RequestBody PacienteRequest dto) {
        return ResponseEntity.status(201).body(service.crear(dto));
    }
}
