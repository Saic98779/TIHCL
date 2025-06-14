package com.metaverse.tihcl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "receivables")
public class Receivable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "to_be_received_from")
    private String toBeReceivedFrom;

    @Column(name = "receivable_date")
    @Temporal(TemporalType.DATE)
    private Date receivableDate;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "diagnostic_report_id")
    private DiagnosticReport diagnosticReport;
}

