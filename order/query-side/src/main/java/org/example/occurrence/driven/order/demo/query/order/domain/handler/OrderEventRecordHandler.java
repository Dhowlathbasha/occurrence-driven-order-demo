package org.example.occurrence.driven.order.demo.query.order.domain.handler;

import org.example.occurrence.driven.order.demo.event.model.OrderEvent;

public interface OrderEventRecordHandler {
    void onEvent(OrderEvent event);
    
}
