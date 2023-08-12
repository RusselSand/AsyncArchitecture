package com.popug.task.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popug.task.model.User;
import com.popug.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserConsumer.class);
    private final UserService service;

    @KafkaListener(topics = "${spring.kafka.topic.name.account}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
        try {
            User user = new ObjectMapper().readValue(message, User.class);
            service.saveUser(user);
            LOGGER.info("User is successfully parsed");
        }
        catch (Exception ex){
            LOGGER.warn("Error while converting to user: " + ex.getMessage());
        }
    }
}
