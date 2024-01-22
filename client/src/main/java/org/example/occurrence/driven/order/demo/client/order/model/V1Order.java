package org.example.occurrence.driven.order.demo.client.order.model;

import lombok.Builder;

import java.time.Instant;

public record V1Order(
        V1OrderStatus status,
        Instant createdDate,
        Instant updatedDate
) {

    @Builder
    public V1Order {
    }
    
}
