package com.devsu.account.controller;

import com.devsu.account.dto.in.FilterRequest;
import com.devsu.account.service.MovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movimientos")
public class MovementController {

    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping(value = "/filter", produces = "application/json")
    public ResponseEntity<?> getMovementByFilterRequest(@RequestBody FilterRequest request) {
        return ResponseEntity.ok(movementService.getMovementByFilterRequest(request));
    }
}
