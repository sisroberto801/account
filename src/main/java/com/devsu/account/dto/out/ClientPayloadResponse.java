package com.devsu.account.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientPayloadResponse {
    @JsonProperty("personaId")
    private Integer personaId;

    @JsonProperty("clienteId")
    private Integer clienteId;

    @JsonProperty("nombre")
    private String nombre;
}