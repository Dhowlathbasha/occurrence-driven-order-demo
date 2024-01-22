package org.example.occurrence.driven.order.demo.query.shipment.domain.handler;

import org.example.occurrence.driven.order.demo.event.model.ShipmentEvent;

public interface ShipmentRecordHandler {

    void onEvent(ShipmentEvent event);

}
