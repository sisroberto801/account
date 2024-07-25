package com.devsu.account.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "MOVIMIENTO")
@Setter
@Getter
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOVIMIENTO_ID")
    private Integer movimientoId;

    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "VALOR")
    private Integer valor;

    @Column(name = "ESTADO")
    private Boolean estado;

    @Column(name = "SALDO_DISPONIBLE")
    private Integer saldoDisponible;

    @ManyToOne
    @JoinColumn(name = "TIPO_MOVIMIENTO_ID")
    @JsonIgnore
    private MovementType movementType;

    @ManyToOne
    @JoinColumn(name = "CUENTA_ID")
    @JsonIgnore
    private Account account;
}
