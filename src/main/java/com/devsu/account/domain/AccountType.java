package com.devsu.account.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TIPO_CUENTA")
@Setter
@Getter
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TIPO_CUENTA_ID")
    private Integer tipoCuentaId;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public AccountType() {
        this.accounts = new ArrayList<>();
    }
}
