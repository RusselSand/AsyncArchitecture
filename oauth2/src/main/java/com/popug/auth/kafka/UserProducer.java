package com.popug.auth.kafka;

import com.google.common.util.concurrent.ListenableFuture;
import com.popug.auth.messages.UserMessage;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProducer.class);

    private KafkaTemplate<Integer, UserMessage> kafkaTemplate;

    public UserProducer(KafkaTemplate<Integer, UserMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserMessage message){
        LOGGER.info(String.format("Message sent %s", message));
        var record = new ProducerRecord<Integer, UserMessage>(topicName, message.getId(), message);
        kafkaTemplate.send(record);
    }
}
