package com.metaverse.tihcl.diagnosticreport.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReceivableDto {
    private Long id;
    private String toBeReceivedFrom;
    private Date receivableDate;
    private Double amount;
}
