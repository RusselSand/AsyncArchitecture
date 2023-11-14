package com.popug.accounting.service;

import com.popug.accounting.model.Task;
import com.popug.accounting.repo.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class TaskService {
    protected final TaskRepo taskRepo;
    protected final UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    public Task saveTask(Task task){
        var oldTask = taskRepo.findByPublicId(task.getPublicId());
        if(oldTask.isPresent()){
            var editTask = oldTask.get();
            editTask.setName(task.getName());
            editTask.setDescription(task.getDescription());
            taskRepo.save(editTask);
        } else{
            Random random = new Random();
            double startPrice = random.nextDouble(10.0) + 10;
            double endPrice = random.nextDouble(20.0) + 20;
            task.setStartPrice(startPrice);
            task.setEndPrice(endPrice);
            taskRepo.save(task);
        }
        return taskRepo.save(task);
    }
}
