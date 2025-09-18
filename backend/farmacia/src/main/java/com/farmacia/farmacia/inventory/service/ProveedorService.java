package com.farmacia.farmacia.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmacia.farmacia.inventory.dto.ProveedorRequest;
import com.farmacia.farmacia.inventory.model.Proveedor;
import com.farmacia.farmacia.inventory.repository.ProveedorRepository;
import com.farmacia.farmacia.shared.exception.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    private final ProveedorRepository repo;

    public List<Proveedor> listar() {
        return repo.findAll();
    }

    public Proveedor buscar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));
    }

    @Transactional
    public Proveedor crear(ProveedorRequest dto) {
        Proveedor p = new Proveedor();
        p.setNombre(dto.getNombre());
        p.setContacto(dto.getContacto());
        return repo.save(p);
    }

    @Transactional
    public Proveedor actualizar(Long id, ProveedorRequest dto) {
        Proveedor p = buscar(id);
        p.setNombre(dto.getNombre());
        p.setContacto(dto.getContacto());
        return repo.save(p);
    }

    @Transactional
    public void eliminar(Long id) {
        repo.delete(buscar(id));
    }
}
