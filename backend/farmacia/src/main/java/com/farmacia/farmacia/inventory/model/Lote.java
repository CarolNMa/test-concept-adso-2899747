package com.farmacia.farmacia.inventory.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter 
@Setter

@Table(name = "lotes")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private Medicamento medicamento;

    @Column(nullable=false)
    private String nroLote;

    @Column(nullable=false)
    private LocalDate fechaVencimiento;

    @Column(nullable=false)
    private Integer stock;
}
