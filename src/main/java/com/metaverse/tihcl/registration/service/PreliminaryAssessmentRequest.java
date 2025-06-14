package com.metaverse.tihcl.registration.service;

import com.metaverse.tihcl.model.CreditFacilityDetails;
import com.metaverse.tihcl.model.StressScore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PreliminaryAssessmentRequest {

    private String enterpriseName;
    private String udyamRegNumber;
    private String district;
    private String mandal;
    private String address;
    private String enterpriseCategory;//Micro, Small, Medium, Large
    private String natureOfActivity;//Manufacturing, services, Trading
    private Boolean existingCredit;
    private List<CreditFacilityDetailsRequest> creditFacilityDetails;
    private String gstNumber;
    private String typeOfProduct;
    private String productUsage;
    private String problemsFaced;
    private String expectedSolution;
    private List<StressScoreRequest> riskCategories;
    private Double riskCategoryScore;
    private String observations;
    private String status;
}
