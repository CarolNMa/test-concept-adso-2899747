package com.farmacia.farmacia.prescription.model;


import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter

@Table(name = "recetas")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private Paciente paciente;

    @ManyToOne(optional=false)
    private Medico medico;

    @Column(nullable=false)
    private LocalDate fecha;
}