package com.metaverse.tihcl.model;

import com.metaverse.tihcl.common.enums.DiagnosticsReportStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "diagnostic_reports")
public class DiagnosticReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "gst_number")
    private String gstNumber;

    @Column(name = "product_manufactured")
    private String productManufactured;

    @Column(name = "demand_for_the_product")
    private String demandForTheProduct;

    @OneToMany(mappedBy = "diagnosticReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shareholder> shareholders = new ArrayList<>();

    @OneToMany(mappedBy = "diagnosticReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Buyer> topBuyers = new ArrayList<>();

    @OneToMany(mappedBy = "diagnosticReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receivable> receivables = new ArrayList<>();

    @OneToMany(mappedBy = "diagnosticReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payable> payables = new ArrayList<>();

    @OneToOne(mappedBy = "diagnosticReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private OperationalStatus operationalStatus;

    @Column(name = "reason_for_stress")
    private String reasonForStress;

    @OneToMany(mappedBy = "diagnosticReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BalanceSheet> balanceSheets = new ArrayList<>();

    @Column(name = "observations")
    private String observations;

    @Column(name = "approval_status")
    private String approvalStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "progress_status")
    private DiagnosticsReportStatus progressStatus;
}
