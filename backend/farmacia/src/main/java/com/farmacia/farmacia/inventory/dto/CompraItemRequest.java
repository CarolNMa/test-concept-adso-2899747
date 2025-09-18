package com.farmacia.farmacia.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraItemRequest {
    @NotNull
    private Long medicamentoId;
    @NotNull
    @Positive
    private Integer cantidad;
    @NotNull
    @Positive
    private Double costoUnitario;
}
