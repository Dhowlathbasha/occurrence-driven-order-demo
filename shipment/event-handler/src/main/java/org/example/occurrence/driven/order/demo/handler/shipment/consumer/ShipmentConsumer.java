package org.example.occurrence.driven.order.demo.handler.shipment.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.occurrence.driven.order.demo.event.model.ShipmentEvent;
import org.example.occurrence.driven.order.demo.handler.shipment.domain.ShipmentEventHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import static org.example.occurrence.driven.order.demo.event.model.ShipmentEvent.SHIPMENT_EVENT_HANDLER_GROUP_ID;
import static org.example.occurrence.driven.order.demo.event.model.ShipmentEvent.SHIPMENT_TOPIC;

@Component
@Slf4j
@RequiredArgsConstructor
public class ShipmentConsumer {

    private final ShipmentEventHandler shipmentEventHandler;

    @KafkaListener(topics = SHIPMENT_TOPIC, groupId = SHIPMENT_EVENT_HANDLER_GROUP_ID)
    public void shipmentEventListener(ShipmentEvent shipmentEvent, Acknowledgment ack) {
        log.info("status handler receive data = {}", shipmentEvent);
        try {
            shipmentEventHandler.onEvent(shipmentEvent)
                    .thenRun(ack::acknowledge);
        } catch (Exception e) {
            log.warn("Fail to handle event {}.", shipmentEvent);
        }
    }
}