package com.metaverse.tihcl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "operational_status")
public class OperationalStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skilled_count")
    private Integer skilledCount;

    @Column(name = "unskilled_count")
    private Integer unskilledCount;

    @Column(name = "female_count")
    private Integer femaleCount;

    @Column(name = "installed_capacity")
    private BigDecimal installedCapacity;

    @Column(name = "utilized_capacity")
    private BigDecimal utilizedCapacity;

    @Column(name = "observation")
    private String observation;

    @Column(name = "is_working")
    private Boolean isWorking;

    @Column(name = "has_unsecured_loans")
    private Boolean hasUnsecuredLoans;

    @Column(name = "required_loan_amount")
    private BigDecimal requiredLoanAmount;

    @Column(name = "loan_security_type")
    private String loanSecurityType;

    @Column(name = "has_statutory_due_pending")
    private Boolean hasStatutoryDuePending;

    @OneToOne
    @JoinColumn(name = "diagnostic_report_id")
    private DiagnosticReport diagnosticReport;

    @OneToMany(mappedBy = "operationalStatus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderBookPosition> orderBookPositions;
}
