package com.popug.task.config;

import com.popug.auth.messages.UserMessage;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

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

    @Bean
    public ConsumerFactory<Integer, UserMessage> consumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, UserMessage>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<Integer, UserMessage> factory = new ConcurrentKafkaListenerContainerFactory<Integer, UserMessage>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }
}
