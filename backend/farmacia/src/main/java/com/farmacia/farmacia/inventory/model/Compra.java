package com.farmacia.farmacia.inventory.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter 
@Setter

@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private Proveedor proveedor;

    @Column(nullable=false)
    private LocalDate fecha;

    @Column(nullable=false)
    private Double total;
}

