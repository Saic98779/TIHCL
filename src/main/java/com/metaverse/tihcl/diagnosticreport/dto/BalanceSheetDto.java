package com.metaverse.tihcl.diagnosticreport.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BalanceSheetDto {
    private Long id;
    private LocalDate reportDate;
    private String financialYear;
    private Double totalReceipts;
    private Double turnoverAsPerBankStatement;
    private Double netProfitOrLoss;
    private Double cashProfitOrLoss;
    private Double sundryCreditors;
    private Double sundryDebtors;
    private Double unsecuredLoans;
    private Double netAddCapInfused;
    private Double tol;
    private Double tnw;
    private Double tolTnwRatio;
    private Double currentAssets;
    private Double currentLiabilities;
    private Double currentRatio;
}