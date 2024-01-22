package org.example.occurrence.driven.order.demo.query.order.domain.handler;

import org.example.occurrence.driven.order.demo.event.model.OrderEvent;

import java.net.SocketException;

public interface OrderRecordHandler {
    void onEvent(OrderEvent event) throws SocketException;

    void onRequeueEvent(OrderEvent event);

}
