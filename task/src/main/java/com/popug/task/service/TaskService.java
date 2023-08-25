package com.popug.task.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.popug.task.kafka.TaskLifeCycleProducer;
import com.popug.task.messages.TaskAssignedMessage;
import com.popug.task.messages.TaskCreatedMessage;
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
    protected final TaskLifeCycleProducer taskLifeCycleProducer;
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
        var task = Task.builder()
                .name(request.getName())
                .description(request.getDescription())
                .publicId(UUID.randomUUID().toString())
                .build();
        task = taskRepo.save(task);
        sendTaskCreatedToKafka(task);
        assignTask(request.getUserEmail(), task);
        return taskMapper.toDto(task);
    }

    private void assignTask(String userEmail, Task task){
        User user = userService.getUser(userEmail);
        task.setAssignee(user);
        taskRepo.save(task);
        sendTaskAssignedToKafka(task.getPublicId(), user.getPublicId());
    }
    private void sendTaskCreatedToKafka(Task task){
        try {
            TaskCreatedMessage msg = TaskCreatedMessage.newBuilder()
                    .setTaskPublicId(task.getPublicId())
                    .setTaskName(task.getName())
                    .setTaskDescription(task.getDescription())
                    .build();
            taskLifeCycleProducer.sendTaskCreatedMessage(msg);
        } catch (Exception ex){
            LOGGER.warn("Error in convert to avro: "+ ex.getMessage());
        }
    }

    private void sendTaskAssignedToKafka(String taskId, String userId){
        try {

            TaskAssignedMessage msg = TaskAssignedMessage.newBuilder()
                    .setUserPublicId(userId)
                    .setTaskPublicId(taskId)
                    .build();
            taskLifeCycleProducer.sendTaskAssignedMessage(msg);
        } catch (Exception ex){
            LOGGER.warn("Error in convert to avro: "+ ex.getMessage());
        }
    }
}
