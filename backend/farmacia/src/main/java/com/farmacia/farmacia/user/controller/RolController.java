package com.farmacia.farmacia.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmacia.farmacia.user.dto.RolRequest;
import com.farmacia.farmacia.user.model.Rol;
import com.farmacia.farmacia.user.service.RolService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {
    private final RolService service;

    @GetMapping
    public List<Rol> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Rol buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public ResponseEntity<Rol> crear(@Valid @RequestBody RolRequest dto) {
        return ResponseEntity.status(201).body(service.crear(dto));
    }
}
