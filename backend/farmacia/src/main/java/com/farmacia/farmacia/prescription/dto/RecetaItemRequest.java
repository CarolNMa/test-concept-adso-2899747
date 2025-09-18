package com.farmacia.farmacia.prescription.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecetaItemRequest {
    @NotNull
    private Long medicamentoId;
    @NotNull
    @Positive
    private Integer cantidad;
    private String indicaciones;
}
