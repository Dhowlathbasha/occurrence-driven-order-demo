package org.example.occurrence.driven.order.demo.handler.shipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EventHandlerShipmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventHandlerShipmentApplication.class, args);
    }

}
