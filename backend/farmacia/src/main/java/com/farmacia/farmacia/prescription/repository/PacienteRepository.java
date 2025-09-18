package com.farmacia.farmacia.prescription.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.prescription.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
