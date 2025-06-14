package com.metaverse.tihcl.diagnosticreport.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrderBookPositionDto {
    private Long id;
    private LocalDate dateOfOrder;
    private String customerName;
    private BigDecimal orderValue;
    private LocalDate orderDeliveryDate;
}
