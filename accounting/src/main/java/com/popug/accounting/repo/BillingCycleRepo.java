package com.popug.accounting.repo;

import com.popug.accounting.model.BillingCicle;
import com.popug.accounting.model.CycleState;
import com.popug.accounting.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillingCycleRepo extends JpaRepository<BillingCicle, Integer> {
    Optional<BillingCicle> findByState(CycleState state);
}
