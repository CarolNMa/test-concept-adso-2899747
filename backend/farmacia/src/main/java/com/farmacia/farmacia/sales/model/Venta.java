package com.farmacia.farmacia.sales.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

import com.farmacia.farmacia.prescription.model.Receta;

@Entity
@Getter
@Setter

@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    private Double total;

    @ManyToOne
    private Receta receta;
}
