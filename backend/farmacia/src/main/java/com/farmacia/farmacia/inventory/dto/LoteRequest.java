package com.farmacia.farmacia.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class LoteRequest {
    @NotNull
    private Long medicamentoId;

    @NotBlank
    private String nroLote;

    @NotNull
    @Future
    private LocalDate fechaVencimiento;

    @NotNull
    @Positive
    private Integer stock;
}
