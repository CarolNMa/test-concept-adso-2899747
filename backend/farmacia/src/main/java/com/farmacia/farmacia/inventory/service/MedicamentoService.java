package com.farmacia.farmacia.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmacia.farmacia.inventory.dto.MedicamentoRequest;
import com.farmacia.farmacia.inventory.model.Medicamento;
import com.farmacia.farmacia.inventory.repository.MedicamentoRepository;
import com.farmacia.farmacia.shared.exception.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicamentoService {
    private final MedicamentoRepository repo;

    public List<Medicamento> listar() {
        return repo.findAll();
    }

    public Medicamento buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Medicamento no encontrado"));
    }

    @Transactional
    public Medicamento crear(MedicamentoRequest dto) {
        Medicamento m = new Medicamento();
        m.setNombre(dto.getNombre());
        m.setDescripcion(dto.getDescripcion());
        m.setLaboratorio(dto.getLaboratorio());
        m.setPrecio(dto.getPrecio());
        m.setEstado(dto.getEstado());
        return repo.save(m);
    }

    @Transactional
    public Medicamento actualizar(Long id, MedicamentoRequest dto) {
        Medicamento m = buscarPorId(id);
        m.setNombre(dto.getNombre());
        m.setDescripcion(dto.getDescripcion());
        m.setLaboratorio(dto.getLaboratorio());
        m.setPrecio(dto.getPrecio());
        m.setEstado(dto.getEstado());
        return repo.save(m);
    }

    @Transactional
    public void eliminar(Long id) {
        repo.delete(buscarPorId(id));
    }
}
