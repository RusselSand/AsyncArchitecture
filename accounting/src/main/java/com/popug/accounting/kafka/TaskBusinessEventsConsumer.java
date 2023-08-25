package com.popug.accounting.kafka;

import com.popug.accounting.messages.TaskAssignedMessage;
import com.popug.accounting.messages.TaskCreatedMessage;
import com.popug.accounting.model.Task;
import com.popug.accounting.model.Transaction;
import com.popug.accounting.service.TaskService;
import com.popug.accounting.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskBusinessEventsConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLifeCycleConsumer.class);
    private final TransactionService service;

    @KafkaListener(topics = "${spring.kafka.topic.name.task_be}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<Integer, TaskAssignedMessage> record){
        LOGGER.info(String.format("Message received -> %s", record));
        try {
            TaskAssignedMessage taskAssignedMessage = record.value();
            service.addTaskToUser(taskAssignedMessage.getUserPublicId().toString(),
                    taskAssignedMessage.getTaskPublicId().toString());
            LOGGER.info("User is successfully parsed");
        }
        catch (Exception ex){
            LOGGER.warn("Error while converting to user: " + ex.getMessage());
        }
    }
}
