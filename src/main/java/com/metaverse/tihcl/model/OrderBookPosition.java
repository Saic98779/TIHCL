package com.metaverse.tihcl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "order_book_position")
public class OrderBookPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOfOrder;

    private String customerName;

    private BigDecimal orderValue;

    private LocalDate orderDeliveryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operational_status_id")
    private OperationalStatus operationalStatus;
}
