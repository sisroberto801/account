package com.devsu.account.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TIPO_MOVIMIENTO")
@Setter
@Getter
public class MovementType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TIPO_MOVIMIENTO_ID")
    private Integer tipoMovimientoId;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "movementType", cascade = CascadeType.ALL)
    private List<Movement> movements;

    public MovementType() {
        this.movements = new ArrayList<>();
    }
}
