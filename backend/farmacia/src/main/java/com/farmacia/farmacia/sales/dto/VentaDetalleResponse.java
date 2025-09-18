package com.farmacia.farmacia.sales.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaDetalleResponse {
    private Long medicamentoId;
    private String medicamento;
    private Integer cantidad;
    private Double precioUnitario;
}
