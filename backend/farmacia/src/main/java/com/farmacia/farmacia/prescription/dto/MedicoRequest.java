package com.farmacia.farmacia.prescription.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoRequest {
    @NotBlank
    private String nombre;

    @NotBlank
    private String registro; 
}
