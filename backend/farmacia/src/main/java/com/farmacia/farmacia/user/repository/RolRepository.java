package com.farmacia.farmacia.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.user.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
