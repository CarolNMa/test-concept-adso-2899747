package com.farmacia.farmacia.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmacia.farmacia.shared.exception.NotFoundException;
import com.farmacia.farmacia.user.dto.UsuarioRequest;
import com.farmacia.farmacia.user.model.Usuario;
import com.farmacia.farmacia.user.repository.UsuarioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repo;

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario buscar(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
    }

    @Transactional
    public Usuario crear(UsuarioRequest dto) {
        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword()); 
        u.setEstado(dto.getEstado());
        return repo.save(u);
    }

    @Transactional
    public Usuario actualizar(Long id, UsuarioRequest dto) {
        Usuario u = buscar(id);
        u.setNombre(dto.getNombre());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        u.setEstado(dto.getEstado());
        return repo.save(u);
    }

    @Transactional
    public void eliminar(Long id) {
        repo.delete(buscar(id));
    }
}
