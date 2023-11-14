package com.popug.auth.kafka;

import com.popug.auth.messages.UserAddedMessage;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserLifeCycleProducer {
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLifeCycleProducer.class);

    private KafkaTemplate<String, UserAddedMessage> kafkaTemplate;

    public UserLifeCycleProducer(KafkaTemplate<String, UserAddedMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserAddedMessage message){
        LOGGER.info(String.format("Message sent %s", message));
        var record = new ProducerRecord<String, UserAddedMessage>(topicName, message.getPublicId().toString(), message);
        kafkaTemplate.send(record);
    }
}
