package com.devsu.account.repository;

import com.devsu.account.domain.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Modifying
    @Transactional
    @Query("delete from Account b where b.clienteId in (:list)")
    int deleteAccountsByClientIds(@Param("list") List<Integer> list);

    @Query("select m.movimientoId from Account b " +
            "inner join Movement m " +
            "on b = m.account " +
            "where b.clienteId in (:list)")
    List<Integer> getMovementIdsByClientIds(@Param("list") List<Integer> list);
}
