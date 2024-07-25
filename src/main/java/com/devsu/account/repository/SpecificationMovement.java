package com.devsu.account.repository;

import com.devsu.account.domain.Movement;
import com.devsu.account.dto.in.FilterRequest;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationMovement {
    Specification<Movement> getSpecificationByFilterRequest(FilterRequest request);
}
