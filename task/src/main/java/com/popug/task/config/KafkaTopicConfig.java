package com.popug.task.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic.name.account}")
    private String topicAccountName;

    @Value("${spring.kafka.topic.name.task}")
    private String topicTaskName;

    @Value("${spring.kafka.topic.name.billing}")
    private String topicBillingName;

    @Bean
    public NewTopic accountTopic(){
        return TopicBuilder.name(topicAccountName)
                .build();
    }

    @Bean
    public NewTopic taskTopic(){
        return TopicBuilder.name(topicTaskName)
                .build();
    }

    @Bean
    public NewTopic billingTopic(){
        return TopicBuilder.name(topicBillingName)
                .build();
    }
}
