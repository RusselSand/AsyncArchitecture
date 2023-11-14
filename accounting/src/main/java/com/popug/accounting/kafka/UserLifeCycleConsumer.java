package com.popug.accounting.kafka;

import com.popug.accounting.messages.UserAddedMessage;
import com.popug.accounting.model.Role;
import com.popug.accounting.model.User;
import com.popug.accounting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLifeCycleConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLifeCycleConsumer.class);
    private final UserService service;

    @KafkaListener(topics = "${spring.kafka.topic.name.account}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<Integer, UserAddedMessage> record){
        LOGGER.info(String.format("Message received -> %s", record));
        try {
            UserAddedMessage userAddedMessage = record.value();
            User userForDb = User.builder()
                    .email(userAddedMessage.getEmail().toString())
                    .publicId(userAddedMessage.getPublicId().toString())
                    .name(userAddedMessage.getName().toString())
                    .role(Role.valueOf(userAddedMessage.getRole().toString())).build();
            service.saveUser(userForDb);
            LOGGER.info("User is successfully parsed");
        }
        catch (Exception ex){
            LOGGER.warn("Error while converting to user: " + ex.getMessage());
        }
    }
}
