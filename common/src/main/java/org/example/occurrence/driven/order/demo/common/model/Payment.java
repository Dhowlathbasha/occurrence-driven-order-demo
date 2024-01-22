package org.example.occurrence.driven.order.demo.common.model;

import lombok.Builder;

public record Payment(String id, String paymentMethod) {

    @Builder
    public Payment {
    }

}
