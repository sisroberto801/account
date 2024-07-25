package com.devsu.account.service.external;

import com.devsu.account.dto.out.ClientPayloadResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(value = "client-service", url = "${gateway.url}")
public interface ClientService {

    @PostMapping(value = "/clientes/read-clients-like-name", produces = "application/json")
    ResponseEntity<List<ClientPayloadResponse>> buildClientIdsLikeName(@RequestBody Map<String, String> data);
}
