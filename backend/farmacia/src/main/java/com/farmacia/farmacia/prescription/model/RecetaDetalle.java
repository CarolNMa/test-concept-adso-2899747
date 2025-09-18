package com.farmacia.farmacia.prescription.model;


import com.farmacia.farmacia.inventory.model.Medicamento;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter

@Table(name = "recetas_detalles")
public class RecetaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private Receta receta;

    @ManyToOne(optional=false)
    private Medicamento medicamento;

    @Column(nullable=false)
    private Integer cantidad;

    private String indicaciones;
}