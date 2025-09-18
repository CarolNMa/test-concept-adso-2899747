package com.farmacia.farmacia.user.dto;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    private Long id;
    private String nombre;
    private String email;
    private String estado;
}
