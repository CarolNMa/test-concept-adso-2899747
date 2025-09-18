package com.farmacia.farmacia.prescription.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.farmacia.farmacia.prescription.dto.PacienteRequest;
import com.farmacia.farmacia.prescription.model.Paciente;
import com.farmacia.farmacia.prescription.repository.PacienteRepository;
import com.farmacia.farmacia.shared.exception.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteRepository repo;

    public List<Paciente> listar() {
        return repo.findAll();
    }

    public Paciente buscar(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Paciente no encontrado"));
    }

    public Paciente crear(PacienteRequest dto) {
        Paciente p = new Paciente();
        p.setNombre(dto.getNombre());
        p.setDocumento(dto.getDocumento());
        return repo.save(p);
    }
}
