package com.farmacia.farmacia.prescription.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.farmacia.farmacia.prescription.dto.MedicoRequest;
import com.farmacia.farmacia.prescription.model.Medico;
import com.farmacia.farmacia.prescription.repository.MedicoRepository;
import com.farmacia.farmacia.shared.exception.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository repo;

    public List<Medico> listar() {
        return repo.findAll();
    }

    public Medico buscar(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Médico no encontrado"));
    }

    public Medico crear(MedicoRequest dto) {
        Medico m = new Medico();
        m.setNombre(dto.getNombre());
        m.setRegistro(dto.getRegistro());
        return repo.save(m);
    }
}
