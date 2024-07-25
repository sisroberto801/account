package com.devsu.account.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUENTA")
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUENTA_ID")
    private Integer cuentaId;

    @Column(name = "CLIENTE_ID")
    private Integer clienteId;

    @Column(name = "NUMERO_CUENTA")
    private Integer numeroCuenta;

    @Column(name = "SALDO_INICIAL")
    private Integer saldoInicial;

    @Column(name = "ESTADO")
    private Boolean estado;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Movement> movements;

    @ManyToOne
    @JoinColumn(name = "TIPO_CUENTA_ID")
    @JsonIgnore
    private AccountType accountType;

    public Account() {
        this.movements = new ArrayList<>();
    }
}
