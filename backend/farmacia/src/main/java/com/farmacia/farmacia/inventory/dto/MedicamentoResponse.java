package com.farmacia.farmacia.inventory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicamentoResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private String laboratorio;
    private Double precio;
    private String estado;
}
