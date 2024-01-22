package org.example.occurrence.driven.order.demo.handler.payment.domain;

import org.example.occurrence.driven.order.demo.event.model.PaymentEvent;

import java.util.concurrent.CompletableFuture;

public interface PaymentEventHandler {

    CompletableFuture<Void> onEvent(PaymentEvent event);

}
