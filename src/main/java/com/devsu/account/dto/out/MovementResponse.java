package com.devsu.account.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovementResponse {
    @JsonProperty("fecha")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha;

    @JsonProperty("cliente")
    private String cliente;

    @JsonProperty("numeroCuenta")
    private Integer numeroCuenta;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("saldoInicial")
    private Integer saldoInicial;

    @JsonProperty("estado")
    private Boolean estado;

    @JsonProperty("movimiento")
    private Integer movimiento;

    @JsonProperty("saldoDisponible")
    private Integer saldoDisponible;
}
