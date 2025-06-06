package com.metaverse.tihcl.registration.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditFacilityDetailsResponse {
    private Long CreditFacilityDetailsId;
    private String bankName;
    private Double limitSanctioned;
    private Double outstandingAmount;
    private Double overdueAmount;
    private String overdueDate;
}
