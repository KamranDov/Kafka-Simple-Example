package com.crocusoft.KafkaExample.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProducerService {

    @Value("${spring.kafka.topic.name}")
    private String firstTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(Object message) {
        this.kafkaTemplate.send(firstTopic, message);
        log.info("Message is sent to kafka: {}", message);
    }
}
