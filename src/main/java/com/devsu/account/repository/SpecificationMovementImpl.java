package com.devsu.account.repository;

import com.devsu.account.domain.Account;
import com.devsu.account.domain.Movement;
import com.devsu.account.dto.in.FilterRequest;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SpecificationMovementImpl implements SpecificationMovement {

    public Specification<Movement> getSpecificationByFilterRequest(FilterRequest request) {
        return (Root<Movement> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) -> {

            Join<Movement, Account> element = root.join("account");

            List<Predicate> predicates = new ArrayList<>();

            if (null != request.getClientIds() && !request.getClientIds().isEmpty()) {
                predicates.add(element.get("clienteId").in(request.getClientIds()));
            }

            if (null != request.getStartDate() && null != request.getEndDate()) {
                predicates.add(cb.between(root.get("fecha"), request.getStartDate(), request.getEndDate()));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}