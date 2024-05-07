package com.crocusoft.KafkaExample.dto;

public record ProductRequest(

        String title,
        String description,
        String color,
        Integer price,
        boolean inStock
) {
}
