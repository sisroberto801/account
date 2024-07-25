package com.devsu.account.dto.in;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovementRequest {
    private Date fecha;
    private String descripcion;
    private Integer valor;
    private Boolean estado;
    private Integer saldoDisponible;
    private Integer movementTypeId;
    private Integer accountId;
}
