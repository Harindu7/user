package com.microservices.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * Send an event to any topic
     * @param topic Kafka topic name
     * @param payload Any object you want to send
     */
    public void sendEvent(String topic, Object payload) {
        kafkaTemplate.send(topic, payload);
    }
}

