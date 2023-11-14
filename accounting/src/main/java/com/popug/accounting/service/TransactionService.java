package com.popug.accounting.service;

import com.popug.accounting.model.BillingCicle;
import com.popug.accounting.model.CycleState;
import com.popug.accounting.repo.BillingCycleRepo;
import com.popug.accounting.repo.TaskRepo;
import com.popug.accounting.model.Task;
import com.popug.accounting.model.Transaction;
import com.popug.accounting.repo.TransactionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TaskRepo taskRepo;
    private final BillingCycleRepo billingCycleRepo;
    private final TransactionRepo transactionRepo;
    public void addTaskToUser(String userId, String taskId){
        Task task = taskRepo.findByPublicId(taskId).orElseThrow();
        BillingCicle cycle = billingCycleRepo.findByState(CycleState.OPEN).orElseThrow();
        Transaction transaction = Transaction.builder()
                .userPublicId(userId)
                .taskPublicId(taskId)
                .credit(task.getStartPrice())
                .description("Task assigned")
                .cycleId(cycle.getId()).build();
        transactionRepo.save(transaction);
    }
}
