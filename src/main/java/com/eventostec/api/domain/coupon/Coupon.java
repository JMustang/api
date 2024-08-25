package com.eventostec.api.domain.coupon;


import com.eventostec.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "coupon")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue
    private UUID id;

    private String code;
    private Integer discount;
    private Data valid;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
