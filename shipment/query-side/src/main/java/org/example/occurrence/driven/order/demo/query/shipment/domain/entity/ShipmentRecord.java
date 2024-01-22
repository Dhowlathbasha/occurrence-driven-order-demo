package org.example.occurrence.driven.order.demo.query.shipment.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.occurrence.driven.order.demo.event.model.ShipmentEventName;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(name = "SHIPMENT_RECORD")
@EntityListeners(AuditingEntityListener.class)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShipmentRecord {

    @Id
    private String shipmentId;

    private String shipmentMethod;

    private ShipmentEventName state;

    private Instant createDate;

    private Instant updateDate;

}
