package org.example.occurrence.driven.order.demo.query.payment.domain.handler;

import org.example.occurrence.driven.order.demo.event.model.PaymentEvent;

public interface PaymentRecordHandler {

    void onEvent(PaymentEvent event);

}
