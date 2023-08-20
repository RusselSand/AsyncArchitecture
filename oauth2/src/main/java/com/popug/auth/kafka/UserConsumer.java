package com.popug.auth.kafka;


import com.popug.auth.messages.UserMessage;
import com.popug.auth.model.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class UserConsumer {
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void read(ConsumerRecord<String, UserMessage> record){
        String key = record.key();
        UserMessage msg = record.value();
        System.out.println();
    }
}
