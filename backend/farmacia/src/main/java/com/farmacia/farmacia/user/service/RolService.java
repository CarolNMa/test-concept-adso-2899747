package com.farmacia.farmacia.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmacia.farmacia.shared.exception.NotFoundException;
import com.farmacia.farmacia.user.dto.RolRequest;
import com.farmacia.farmacia.user.model.Rol;
import com.farmacia.farmacia.user.repository.RolRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolService {
    private final RolRepository repo;

    public List<Rol> listar() {
        return repo.findAll();
    }

    public Rol buscar(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Rol no encontrado"));
    }

    @Transactional
    public Rol crear(RolRequest dto) {
        Rol r = new Rol();
        r.setNombre(dto.getNombre());
        return repo.save(r);
    }
}
