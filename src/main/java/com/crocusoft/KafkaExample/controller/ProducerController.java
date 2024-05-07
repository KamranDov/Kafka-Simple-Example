package com.crocusoft.KafkaExample.controller;

import com.crocusoft.KafkaExample.dto.ProductRequest;
import com.crocusoft.KafkaExample.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producer")
public class ProducerController {

    private final ProducerService producerService;

    @GetMapping
    public ResponseEntity<String> healthCheck(@RequestBody String message) {
        producerService.send(message);
        return new ResponseEntity<>("message success", HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Void> sendProductMessage(@RequestBody ProductRequest productRequest) {
        producerService.send(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
