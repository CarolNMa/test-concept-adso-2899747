package com.farmacia.farmacia.prescription.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class RecetaRequest {
    @NotNull
    private Long pacienteId;

    @NotNull
    private Long medicoId;

    @NotNull
    private LocalDate fecha;

    @NotEmpty
    private List<RecetaItemRequest> items;

   
}
