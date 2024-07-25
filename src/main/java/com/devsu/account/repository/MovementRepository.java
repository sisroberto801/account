package com.devsu.account.repository;

import com.devsu.account.domain.Movement;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Integer>
        , JpaSpecificationExecutor<Movement>
        , SpecificationMovement {

    @Modifying
    @Transactional
    @Query("delete from Movement m where m.movimientoId in (:list)")
    int deleteMovementsByMovementIds(@Param("list") List<Integer> list);
}
