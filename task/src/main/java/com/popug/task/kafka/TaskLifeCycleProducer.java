package com.popug.task.kafka;

import com.popug.task.messages.TaskAssignedMessage;
import com.popug.task.messages.TaskCreatedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskLifeCycleProducer {
    @Value("${spring.kafka.topic.name.task}")
    private String topicTaskLifeCycleName;
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskLifeCycleProducer.class);
    private KafkaTemplate<String, TaskAssignedMessage> taskAssignedTemplate;
    private KafkaTemplate<String, TaskCreatedMessage> taskCreatedTemplate;

    public TaskLifeCycleProducer(KafkaTemplate<String, TaskAssignedMessage> taskAssignedTemplate,
                                 KafkaTemplate<String, TaskCreatedMessage> taskCreatedTemplate){
        this.taskAssignedTemplate = taskAssignedTemplate;
        this.taskCreatedTemplate = taskCreatedTemplate;
    }

    public void sendTaskCreatedMessage(TaskCreatedMessage message){
        taskCreatedTemplate.send(topicTaskLifeCycleName, message);
        LOGGER.info(String.format("Message sent %s", message));
    }

    public void sendTaskAssignedMessage(TaskAssignedMessage message){
        taskAssignedTemplate.send(topicTaskLifeCycleName, message);
        LOGGER.info(String.format("Message sent %s", message));
    }

}
