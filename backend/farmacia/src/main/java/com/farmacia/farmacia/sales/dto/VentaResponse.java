package com.farmacia.farmacia.sales.dto;



import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class VentaResponse {
    private Long id;
    private LocalDateTime fecha;
    private Double total;
    private Long recetaId;
    private List<VentaDetalleResponse> detalles;

}
