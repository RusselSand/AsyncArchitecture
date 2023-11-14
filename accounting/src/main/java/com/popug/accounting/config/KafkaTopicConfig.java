package com.popug.accounting.config;

import com.popug.accounting.messages.TaskAssignedMessage;
import com.popug.accounting.messages.TaskCreatedMessage;
import com.popug.accounting.messages.UserAddedMessage;
import com.popug.accounting.model.Task;
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
    public ConsumerFactory<String, TaskCreatedMessage> taskCreatedFactory(KafkaProperties kafkaProperties){
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }
    @Bean
    public ConsumerFactory<String, TaskAssignedMessage> taskAssignedFactory(KafkaProperties kafkaProperties){
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, UserAddedMessage>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, UserAddedMessage> factory = new ConcurrentKafkaListenerContainerFactory<String, UserAddedMessage>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, TaskCreatedMessage>>
    taskCreatedListenerContainerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, TaskCreatedMessage> factory = new ConcurrentKafkaListenerContainerFactory<String, TaskCreatedMessage>();
        factory.setConsumerFactory(taskCreatedFactory(kafkaProperties));
        return factory;
    }
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, TaskAssignedMessage>>
    taskAssignedListenerContainerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, TaskAssignedMessage> factory = new ConcurrentKafkaListenerContainerFactory<String, TaskAssignedMessage>();
        factory.setConsumerFactory(taskAssignedFactory(kafkaProperties));
        return factory;
    }
}
