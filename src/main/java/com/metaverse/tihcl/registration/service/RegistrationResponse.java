package com.metaverse.tihcl.registration.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationResponse {
    private Long registrationId;
    private String enterpriseName;
    private String promoterName;
    private String constitution;
    private String productionDate;
    private String udyamRegNumber;
    private Long contactNumber;
    private String industrialPark;
    private String state;
    private String district;
    private String mandal;
    private String email;
    private String address;
    private String enterpriseCategory;
    private String natureOfActivity;
    private String sector;
    private Boolean operationStatus;
    private String operatingSatisfactorily;
    private String operatingDifficulties;
    private String issueDate;
    private String reasonForNotOperating;
    private String restartSupport;
    private Boolean restartIntent;
    private Boolean existingCredit;
    private List<CreditFacilityDetailsResponse> creditFacilityDetails;
    private String unitStatus;
    private Double requiredCreditLimit;
    private Boolean investmentSubsidy;
    private Double totalAmountSanctioned;
    private Double amountReleased;
    private Double amountToBeReleased;
    private String maintainingAccountBy;
    private String helpMsg;
    private String applicationNo;
    private String status;
    private String dateOfSubmission;
}
