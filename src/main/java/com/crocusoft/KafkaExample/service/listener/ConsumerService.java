package com.crocusoft.KafkaExample.service.listener;

import com.crocusoft.KafkaExample.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsumerService {

    @KafkaListener(topics = "${spring.kafka.topic.name}")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info(payload.value());
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}")
    public void consumeObject(ConsumerRecord<String, ProductRequest> payload) {
        log.info(String.valueOf(payload.value()));
    }
}
