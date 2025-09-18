package com.farmacia.farmacia.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicamentoRequest {
    @NotBlank
    private String nombre;

    private String descripcion;
    private String laboratorio;

    @NotNull
    @Positive
    private Double precio;

    @NotBlank
    private String estado; // ACTIVO / INACTIVO
}
