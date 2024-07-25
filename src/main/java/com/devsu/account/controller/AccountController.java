package com.devsu.account.controller;

import com.devsu.account.dto.in.AccountRequest;
import com.devsu.account.dto.out.AccountResponse;
import com.devsu.account.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cuentas")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<AccountResponse> createUser(
            @RequestBody AccountRequest data
    ) throws ClassNotFoundException {

        return ResponseEntity.ok(service.create(data));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<AccountResponse> updateUser(
            @PathVariable Integer id, @RequestBody AccountRequest data
    ) throws ClassNotFoundException {

        return ResponseEntity.ok(service.update(id, data));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) throws ClassNotFoundException {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/clients-id-list", produces = "application/json")
    public ResponseEntity<Integer> deleteAccountsByClientIds(@RequestBody List<Integer> list) {
        return ResponseEntity.ok(service.deleteAccountsByClientIds(list));
    }
}
