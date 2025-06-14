package com.metaverse.tihcl.registration.service;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreliminaryAssessmentResponse {

    private String enterpriseName;
    private String udyamRegNumber;
    private String district;
    private String mandal;
    private String address;
    private String enterpriseCategory;//Micro, Small, Medium, Large
    private String natureOfActivity;//Manufacturing, services, Trading
    private Boolean existingCredit;
    private List<CreditFacilityDetailsResponse> creditFacilityDetails;
    private String gstNumber;
    private String typeOfProduct;
    private String productUsage;
    private String problemsFaced;
    private String expectedSolution;
    private List<StressScoreResponse> riskCategories;
    private Double riskCategoryScore;
    private String observations;
    private String status;
}
