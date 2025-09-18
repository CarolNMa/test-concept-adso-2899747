package com.farmacia.farmacia.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmacia.farmacia.inventory.dto.CategoriaRequest;
import com.farmacia.farmacia.inventory.model.Categoria;
import com.farmacia.farmacia.inventory.repository.CategoriaRepository;
import com.farmacia.farmacia.shared.exception.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository repo;

    public List<Categoria> listar() {
        return repo.findAll();
    }

    public Categoria buscar(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
    }

    @Transactional
    public Categoria crear(CategoriaRequest dto) {
        Categoria c = new Categoria();
        c.setNombre(dto.getNombre());
        return repo.save(c);
    }

    @Transactional
    public Categoria actualizar(Long id, CategoriaRequest dto) {
        Categoria c = buscar(id);
        c.setNombre(dto.getNombre());
        return repo.save(c);
    }

    @Transactional
    public void eliminar(Long id) {
        repo.delete(buscar(id));
    }
}
