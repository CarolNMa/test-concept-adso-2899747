package com.farmacia.farmacia.sales.model;

import com.farmacia.farmacia.inventory.model.Medicamento;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter

@Table(name = "detalle_ventas")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private Venta venta;

    @ManyToOne(optional=false)
    private Medicamento medicamento;

    @Column(nullable=false)
    private Integer cantidad;

    @Column(nullable=false)
    private Double precioUnitario;
}
