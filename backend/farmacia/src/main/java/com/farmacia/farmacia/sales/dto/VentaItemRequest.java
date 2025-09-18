package com.farmacia.farmacia.sales.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaItemRequest {
    @NotNull
    private Long medicamentoId;
    @NotNull
    @Positive
    private Integer cantidad;
}
