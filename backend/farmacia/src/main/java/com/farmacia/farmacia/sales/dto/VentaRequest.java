package com.farmacia.farmacia.sales.dto;



import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class VentaRequest {
    private Long recetaId; 

    @NotEmpty
    private List<VentaItemRequest> items;

 
}
