package com.devsu.account.service;

import com.devsu.account.domain.Account;
import com.devsu.account.domain.AccountType;
import com.devsu.account.dto.in.AccountRequest;
import com.devsu.account.dto.out.AccountResponse;
import com.devsu.account.repository.AccountRepository;
import com.devsu.account.repository.AccountTypeRepository;
import com.devsu.account.repository.MovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountTypeRepository accountTypeRepository;
    private final AccountRepository accountRepository;
    private final MovementRepository movementRepository;

    public AccountService(AccountTypeRepository accountTypeRepository, AccountRepository accountRepository, MovementRepository movementRepository) {
        this.accountTypeRepository = accountTypeRepository;
        this.accountRepository = accountRepository;
        this.movementRepository = movementRepository;
    }

    public Integer deleteAccountsByClientIds(List<Integer> list) {
        List<Integer> movIdList = accountRepository.getMovementIdsByClientIds(list);
        movementRepository.deleteMovementsByMovementIds(movIdList);
        return accountRepository.deleteAccountsByClientIds(list);
    }

    public void delete(Integer id) throws ClassNotFoundException {
        accountRepository.delete(this.get(id));
    }

    public Account get(Integer id) throws ClassNotFoundException {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException("Not found Account id: " + id));
    }

    public AccountType getAccountType(Integer id) throws ClassNotFoundException {
        return accountTypeRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException("Not found Account Type id: " + id));
    }

    public AccountResponse create(AccountRequest input) throws ClassNotFoundException {

        AccountType accountType = getAccountType(input.getTipoCuentaId());
        Account account = this.converterRequestToObject(new Account(), accountType, input);

        return this.converterObjectToResponse(
                new AccountResponse(),
                accountRepository.save(account)
        );
    }

    public AccountResponse update(Integer id, AccountRequest input) throws ClassNotFoundException {

        AccountType accountType = getAccountType(input.getTipoCuentaId());
        Account account = this.converterRequestToObject(this.get(id), accountType, input);

        return this.converterObjectToResponse(
                new AccountResponse(),
                accountRepository.save(account)
        );
    }

    private Account converterRequestToObject(Account account, AccountType accountType, AccountRequest input) {
        account.setClienteId(input.getClienteId());
        account.setNumeroCuenta(input.getNumeroCuenta());
        account.setSaldoInicial(input.getSaldoInicial());
        account.setEstado(input.getEstado());
        account.setAccountType(accountType);
        return account;
    }

    private AccountResponse converterObjectToResponse(AccountResponse output, Account input) {
        output.setCuentaId(input.getCuentaId());
        output.setClienteId(input.getClienteId());
        output.setNumeroCuenta(input.getNumeroCuenta());
        output.setSaldoInicial(input.getSaldoInicial());
        output.setEstado(input.getEstado());
        output.setNombreTipoCuenta(null != input.getAccountType() ? input.getAccountType().getNombre() : null);
        return output;
    }
}
