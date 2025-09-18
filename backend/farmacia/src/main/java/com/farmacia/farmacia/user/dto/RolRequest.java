package com.farmacia.farmacia.user.dto;



import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolRequest {
    @NotBlank
    private String nombre;
}
