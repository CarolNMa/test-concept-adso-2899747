package com.farmacia.farmacia.inventory.dto;



import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProveedorRequest {
    @NotBlank
    private String nombre;

    private String contacto;
}
