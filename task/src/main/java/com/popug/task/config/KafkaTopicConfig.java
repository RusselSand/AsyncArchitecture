package com.popug.task.config;

import com.popug.task.messages.UserAddedMessage;
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
    private String topicUserLifeCycleName;

    @Value("${spring.kafka.topic.name.task}")
    private String topicTaskLifeCycleName;

    @Bean
    public NewTopic userLifeCycleTopic(){
        return TopicBuilder.name(topicUserLifeCycleName)
                .build();
    }

    @Bean
    public NewTopic taskLifeCycleTopic(){
        return TopicBuilder.name(topicTaskLifeCycleName)
                .build();
    }

    @Bean
    public ConsumerFactory<String, UserAddedMessage> consumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, UserAddedMessage>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, UserAddedMessage> factory = new ConcurrentKafkaListenerContainerFactory<String, UserAddedMessage>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }
}
