package com.farmacia.farmacia.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CompraRequest {
    @NotNull
    private Long proveedorId;

    @NotNull
    private LocalDate fecha;

    @NotNull
    @Positive
    private Double total;

    @NotEmpty
    private List<CompraItemRequest> items;
}
