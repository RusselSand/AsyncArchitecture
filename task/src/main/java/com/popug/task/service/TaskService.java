package com.popug.task.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.popug.task.kafka.BillingProducer;
import com.popug.task.model.Task;
import com.popug.task.model.TaskDto;
import com.popug.task.model.TaskMapper;
import com.popug.task.model.User;
import com.popug.task.repo.TaskRepo;
import com.popug.task.request.CreateTaskRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    protected final TaskRepo taskRepo;
    protected final TaskMapper taskMapper;
    protected final UserService userService;
    protected final BillingProducer billingProducer;
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    public TaskDto getTaskById(Integer id){
        return taskMapper.toDto(taskRepo.findById(id).orElseThrow());
    }

    public List<TaskDto> getAllTasks(){
        List<Task> result = taskRepo.findAll();
        return result.stream().map(taskMapper::toDto).collect(Collectors.toList());
    }

    public TaskDto addTask(CreateTaskRequest request){
        Random random = new Random();
        int price = random.nextInt(20) + 20;
        var task = Task.builder()
                .name(request.getName())
                .description(request.getDescription())
                .assignee(userService.getUser(request.getUserEmail()))
                .price(price)
                .publicId(UUID.randomUUID().toString())
                .build();
        task = taskRepo.save(task);
        return taskMapper.toDto(task);
    }

    private void sendTaskToKafka(Task task){
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String userJson = ow.writeValueAsString(taskMapper.toDto(task));
            billingProducer.sendMessage(userJson);
        } catch (Exception ex){
            LOGGER.warn("Error in convert to json: "+ ex.getMessage());
        }
    }
}
