package com.farmacia.farmacia.inventory.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "detalle_compras")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private Compra compra;

    @ManyToOne(optional=false)
    private Medicamento medicamento;

    @Column(nullable=false)
    private Integer cantidad;

    @Column(nullable=false)
    private Double costoUnitario;
}
