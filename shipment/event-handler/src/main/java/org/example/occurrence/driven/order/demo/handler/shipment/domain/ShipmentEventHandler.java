package org.example.occurrence.driven.order.demo.handler.shipment.domain;

import org.example.occurrence.driven.order.demo.event.model.ShipmentEvent;

import java.util.concurrent.CompletableFuture;

public interface ShipmentEventHandler {

    CompletableFuture<Void> onEvent(ShipmentEvent event);

}
