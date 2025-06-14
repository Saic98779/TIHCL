package com.metaverse.tihcl.diagnosticreport.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OperationalStatusDto {
    private Long id;
    private Integer skilledCount;
    private Integer unskilledCount;
    private Integer femaleCount;
    private BigDecimal installedCapacity;
    private BigDecimal utilizedCapacity;
    private String observation;
    private Boolean isWorking;
    private Boolean hasUnsecuredLoans;
    private BigDecimal requiredLoanAmount;
    private String loanSecurityType;
    private Boolean hasStatutoryDuePending;
    private List<OrderBookPositionDto> orderBookPositions;
}
