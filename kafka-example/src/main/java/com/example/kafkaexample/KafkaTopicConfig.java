package com.example.kafkaexample;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    //We need to add the KafkaAdmin Spring bean, which will automatically add topics for all beans
    //of the type NewTopic

    @Value( value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs= new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("kafkaExample",1,(short) 1);
    }

}
