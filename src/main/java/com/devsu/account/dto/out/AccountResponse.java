package com.devsu.account.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountResponse {
    @JsonProperty("cuentaId")
    private Integer cuentaId;
    @JsonProperty("clienteId")
    private Integer clienteId;
    @JsonProperty("numeroCuenta")
    private Integer numeroCuenta;
    @JsonProperty("saldoInicial")
    private Integer saldoInicial;
    @JsonProperty("estado")
    private Boolean estado;
    @JsonProperty("nombreTipoCuenta")
    private String nombreTipoCuenta;
}
