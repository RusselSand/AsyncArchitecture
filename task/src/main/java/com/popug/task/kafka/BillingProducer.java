package com.popug.task.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BillingProducer {
    @Value("${spring.kafka.topic.name.billing}")
    private String topicName;
    private static final Logger LOGGER = LoggerFactory.getLogger(BillingProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public BillingProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send(topicName, message);
    }

}
