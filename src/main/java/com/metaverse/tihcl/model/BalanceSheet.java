package com.metaverse.tihcl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "balance_sheets")
public class BalanceSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "financial_year")
    private String financialYear;

    @Column(name = "total_receipts")
    private Double totalReceipts;

    @Column(name = "turnover_as_per_bank_statement")
    private Double turnoverAsPerBankStatement;

    @Column(name = "net_profit_or_loss")
    private Double netProfitOrLoss;

    @Column(name = "cash_profit_or_loss")
    private Double cashProfitOrLoss;

    @Column(name = "sundry_creditors")
    private Double sundryCreditors;

    @Column(name = "sundry_debtors")
    private Double sundryDebtors;

    @Column(name = "unsecured_loans")
    private Double unsecuredLoans;

    @Column(name = "net_add_cap_infused")
    private Double netAddCapInfused;

    @Column(name = "tol")
    private Double tol;

    @Column(name = "tnw")
    private Double tnw;

    @Column(name = "tol_tnw_ratio")
    private Double tolTnwRatio;

    @Column(name = "current_assets")
    private Double currentAssets;

    @Column(name = "current_liabilities")
    private Double currentLiabilities;

    @Column(name = "current_ratio")
    private Double currentRatio;

    @ManyToOne
    @JoinColumn(name = "diagnostic_report_id")
    private DiagnosticReport diagnosticReport;
}

