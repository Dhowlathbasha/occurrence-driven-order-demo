package org.example.occurrence.driven.order.demo.handler.order.domain;

import org.example.occurrence.driven.order.demo.event.model.OrderEvent;

import java.util.concurrent.CompletableFuture;

public interface OrderEventHandler {

    CompletableFuture<Void> onEvent(OrderEvent event);

}
