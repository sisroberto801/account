package com.devsu.account.service;

import com.devsu.account.domain.Movement;
import com.devsu.account.dto.in.FilterRequest;
import com.devsu.account.dto.out.ClientPayloadResponse;
import com.devsu.account.dto.out.MovementResponse;
import com.devsu.account.repository.MovementRepository;
import com.devsu.account.service.external.ClientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovementService {
    private final MovementRepository movementRepository;
    private final ClientService clientService;

    public MovementService(MovementRepository movementRepository, ClientService clientService) {
        this.movementRepository = movementRepository;
        this.clientService = clientService;
    }

    public List<MovementResponse> getMovementByFilterRequest(FilterRequest request) {

        List<MovementResponse> output = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("name", request.getName());

        List<ClientPayloadResponse> list = clientService.buildClientIdsLikeName(map).getBody();

        request.setClientIds(this.buildClientIds(list));
        List<Movement> movements = movementRepository.findAll(
                movementRepository.getSpecificationByFilterRequest(request),
                PageRequest.of(0, Integer.MAX_VALUE)
        ).getContent();


        movements.forEach(movement -> {
            for (ClientPayloadResponse payload : list) {
                if (payload.getClienteId().equals(movement.getAccount().getClienteId())) {
                    output.add(this.buildMovResponse(payload, movement));
                    break;
                }
            }
        });

        return output;
    }

    private MovementResponse buildMovResponse(ClientPayloadResponse payload, Movement data) {
        MovementResponse output = new MovementResponse();
        output.setFecha(data.getFecha());
        output.setCliente(payload.getNombre());
        output.setNumeroCuenta(data.getAccount().getNumeroCuenta());
        output.setTipo(data.getAccount().getAccountType().getNombre());
        output.setSaldoInicial(data.getAccount().getSaldoInicial());
        output.setEstado(data.getEstado());
        output.setMovimiento(data.getValor());
        output.setSaldoDisponible(data.getSaldoDisponible());
        return output;
    }

    private List<Integer> buildClientIds(List<ClientPayloadResponse> list) {
        List<Integer> output = new ArrayList<>();
        if (null == list) {
            return output;
        }
        list.forEach(item -> output.add(item.getClienteId()));
        return output;
    }
}
