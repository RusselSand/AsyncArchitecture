package com.popug.accounting.kafka;

import com.popug.accounting.messages.TaskCreatedMessage;
import com.popug.accounting.messages.UserAddedMessage;
import com.popug.accounting.model.Role;
import com.popug.accounting.model.Task;
import com.popug.accounting.model.User;
import com.popug.accounting.service.TaskService;
import com.popug.accounting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class TaskLifeCycleConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLifeCycleConsumer.class);
    private final TaskService service;

    @KafkaListener(topics = "${spring.kafka.topic.name.task}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<Integer, TaskCreatedMessage> record){
        LOGGER.info(String.format("Message received -> %s", record));
        try {
            TaskCreatedMessage taskCreatedMessage = record.value();
            Task task = Task.builder()
                            .name(taskCreatedMessage.getTaskName().toString())
                            .description(taskCreatedMessage.getTaskDescription().toString())
                            .publicId(taskCreatedMessage.getTaskPublicId().toString()).build();
            service.saveTask(task);
            LOGGER.info("User is successfully parsed");
        }
        catch (Exception ex){
            LOGGER.warn("Error while converting to user: " + ex.getMessage());
        }
    }
}
