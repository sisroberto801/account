package com.devsu.account.dto.in;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {
    private Integer clienteId;
    private Integer numeroCuenta;
    private Integer saldoInicial;
    private Boolean estado;
    private Integer tipoCuentaId;
}
