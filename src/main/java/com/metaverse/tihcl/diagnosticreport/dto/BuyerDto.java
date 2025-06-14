package com.metaverse.tihcl.diagnosticreport.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BuyerDto {
    private Long id;
    private String buyerName;
    private Integer purchasedQty;
    private BigDecimal amount;
    private String remarks;
}
