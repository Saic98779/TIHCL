package com.metaverse.tihcl.diagnosticreport.dto;

import com.metaverse.tihcl.common.enums.DiagnosticsReportStatus;
import lombok.Data;

import java.util.List;

@Data
public class DiagnosticReportDto {
    private Long id;

    private String name;

    private String contactNo;

    private String gstNumber;

    private String productManufactured;

    private String demandForTheProduct;

    private List<ShareholderDto> shareholders;

    private List<BuyerDto> topBuyers;

    private List<ReceivableDto> receivables;

    private List<PayableDto> payables;

    private OperationalStatusDto operationalStatus;

    private String reasonForStress;

    private List<BalanceSheetDto> balanceSheets;

    private String observations;

    private String approvalStatus;

    private DiagnosticsReportStatus currentScreenStatus;
}
