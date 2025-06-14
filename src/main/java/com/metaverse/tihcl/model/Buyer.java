package com.metaverse.tihcl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "buyers")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "buyer_name")
    private String buyerName;

    @Column(name = "purchased_qty")
    private Integer purchasedQty;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnostic_report_id")
    private DiagnosticReport diagnosticReport;
}
