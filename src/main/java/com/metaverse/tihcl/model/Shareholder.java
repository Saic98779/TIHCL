package com.metaverse.tihcl.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shareholders")
public class Shareholder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "num_of_shares")
    private Integer numOfShares;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnostic_report_id")
    private DiagnosticReport diagnosticReport;
}
