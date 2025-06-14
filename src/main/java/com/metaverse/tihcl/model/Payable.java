package com.metaverse.tihcl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "payables")
public class Payable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "to_be_paid_to")
    private String toBePaidTo;

    @Column(name = "payable_date")
    @Temporal(TemporalType.DATE)
    private Date payableDate;

    @Column(name = "payable_amount")
    private Double payableAmount;

    @ManyToOne
    @JoinColumn(name = "diagnostic_report_id")
    private DiagnosticReport diagnosticReport;
}
