package com.metaverse.tihcl.diagnosticreport.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PayableDto {
    private Long id;
    private String toBePaidTo;
    private Date payableDate;
    private Double payableAmount;
}