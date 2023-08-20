package com.popug.task.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popug.auth.messages.UserMessage;
import com.popug.task.model.Role;
import com.popug.task.model.User;
import com.popug.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.avro.util.Utf8;
import org.apache.kafka.clients.consumer.ConsumerRecord;
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
    public void consume(ConsumerRecord<Integer, UserMessage> record){
        LOGGER.info(String.format("Message received -> %s", record));
        try {
            UserMessage user = record.value();
            User userForDb = User.builder()
                    .email(user.getEmail().toString())
                    .publicId(user.getPublicId().toString())
                    .name(user.getName().toString())
                    .role(Role.valueOf(user.getRole().toString())).build();
            service.saveUser(userForDb);
            LOGGER.info("User is successfully parsed");
        }
        catch (Exception ex){
            LOGGER.warn("Error while converting to user: " + ex.getMessage());
        }
    }
}
