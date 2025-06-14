package com.metaverse.tihcl.registration.service;

import com.metaverse.tihcl.common.util.DateUtil;
import com.metaverse.tihcl.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class RegistrationResponseMapper {

    public static RegistrationResponse map(Registration registration) {
        if (registration == null) {
            return null;
        }

        return RegistrationResponse.builder()
                .registrationId(registration.getRegistrationId())
                .enterpriseName(registration.getEnterpriseName())
                .promoterName(registration.getPromoterName())
                .constitution(registration.getConstitution())
                .productionDate(registration.getProductionDate() != null ? DateUtil.dateToString(registration.getProductionDate()) : null)
                .udyamRegNumber(registration.getUdyamRegNumber())
                .contactNumber(registration.getContactNumber())
                .industrialPark(registration.getIndustrialPark())
                .state(registration.getState())
                .district(registration.getDistrict())
                .mandal(registration.getMandal())
                .email(registration.getEmail())
                .address(registration.getAddress())
                .enterpriseCategory(registration.getEnterpriseCategory())
                .natureOfActivity(registration.getNatureOfActivity())
                .sector(registration.getSector())
                .operationStatus(registration.getOperationStatus())
                .operatingSatisfactorily(registration.getOperatingSatisfactorily())
                .operatingDifficulties(registration.getOperatingDifficulties())
                .issueDate(registration.getProductionDate() != null ? DateUtil.dateToString(registration.getIssueDate()) : null)
                .reasonForNotOperating(registration.getReasonForNotOperating())
                .restartSupport(registration.getRestartSupport())
                .restartIntent(registration.getRestartIntent())
                .existingCredit(registration.getExistingCredit())
                .creditFacilityDetails(mapCreditFacilityDetails(registration.getCreditFacilityDetails()))
                .unitStatus(registration.getUnitStatus())
                .requiredCreditLimit(registration.getRequiredCreditLimit())
                .investmentSubsidy(registration.getInvestmentSubsidy())
                .totalAmountSanctioned(registration.getTotalAmountSanctioned())
                .amountReleased(registration.getAmountReleased())
                .amountToBeReleased(registration.getAmountToBeReleased())
                .helpMsg(registration.getHelpMsg())
                .maintainingAccountBy(registration.getMaintainingAccountBy())
                .applicationNo(registration.getApplicationNo())
                .status(registration.getStatus())
                .dateOfSubmission(DateUtil.dateToString(registration.getCreatedOn()))
                .build();
    }

    public static RegistrationResponse map(RegistrationUsage registration) {
        if (registration == null) {
            return null;
        }

        return RegistrationResponse.builder()
                .registrationId(registration.getRegistrationUsageId())
                .enterpriseName(registration.getEnterpriseName())
                .promoterName(registration.getPromoterName())
                .constitution(registration.getConstitution())
                .productionDate(registration.getProductionDate() != null ? DateUtil.dateToString(registration.getProductionDate()) : null)
                .udyamRegNumber(registration.getUdyamRegNumber())
                .contactNumber(registration.getContactNumber())
                .industrialPark(registration.getIndustrialPark())
                .state(registration.getState())
                .district(registration.getDistrict())
                .mandal(registration.getMandal())
                .email(registration.getEmail())
                .address(registration.getAddress())
                .enterpriseCategory(registration.getEnterpriseCategory())
                .natureOfActivity(registration.getNatureOfActivity())
                .sector(registration.getSector())
                .operationStatus(registration.getOperationStatus())
                .operatingSatisfactorily(registration.getOperatingSatisfactorily())
                .operatingDifficulties(registration.getOperatingDifficulties())
                .issueDate(registration.getProductionDate() != null ? DateUtil.dateToString(registration.getIssueDate()) : null)
                .reasonForNotOperating(registration.getReasonForNotOperating())
                .restartSupport(registration.getRestartSupport())
                .restartIntent(registration.getRestartIntent())
                .existingCredit(registration.getExistingCredit())
               // .creditFacilityDetails(mapCreditFacilityDetails(registration.getCreditFacilityDetails()))
                .unitStatus(registration.getUnitStatus())
                .requiredCreditLimit(registration.getRequiredCreditLimit())
                .investmentSubsidy(registration.getInvestmentSubsidy())
                .totalAmountSanctioned(registration.getTotalAmountSanctioned())
                .amountReleased(registration.getAmountReleased())
                .amountToBeReleased(registration.getAmountToBeReleased())
                .helpMsg(registration.getHelpMsg())
                .maintainingAccountBy(registration.getMaintainingAccountBy())
                .applicationNo(registration.getApplicationNo())
                .status(registration.getStatus())
                .dateOfSubmission(DateUtil.dateToString(registration.getCreatedOn()))
                .build();
    }

    private static List<CreditFacilityDetailsResponse> mapCreditFacilityDetails(List<CreditFacilityDetails> detailsList) {
        if (detailsList == null) {
            return null;
        }

        return detailsList.stream()
                .map(detail -> CreditFacilityDetailsResponse.builder()
                        .CreditFacilityDetailsId(detail.getCreditFacilityDetailsId())
                        .bankName(detail.getBankName())
                        .limitSanctioned(detail.getLimitSanctioned())
                        .outstandingAmount(detail.getOutstandingAmount())
                        .overdueAmount(detail.getOverdueAmount())
                        .overdueDate(detail.getOverdueDate() != null ? DateUtil.dateToString(detail.getOverdueDate()) : null)
                        .build())
                .collect(Collectors.toList());
    }
    private static List<CreditFacilityDetailsResponse> mapCreditFacilityDetailsUsage(List<CreditFacilityDetailsUsage> detailsList) {
        if (detailsList == null) {
            return null;
        }

        return detailsList.stream()
                .map(detail -> CreditFacilityDetailsResponse.builder()
                        .CreditFacilityDetailsId(detail.getCreditFacilityDetailsId())
                        .bankName(detail.getBankName())
                        .limitSanctioned(detail.getLimitSanctioned())
                        .outstandingAmount(detail.getOutstandingAmount())
                        .overdueAmount(detail.getOverdueAmount())
                        .overdueDate(detail.getOverdueDate() != null ? DateUtil.dateToString(detail.getOverdueDate()) : null)
                        .build())
                .collect(Collectors.toList());
    }


    private static List<StressScoreResponse> mapStressScore(List<StressScore> scores) {
        if (scores == null) {
            return null;
        }

        return scores.stream()
                .map(score -> StressScoreResponse.builder()
                        .issue(score.getIssues())
                        .riskCategorisation(score.getRiskCategorisation())
                        .build())
                .collect(Collectors.toList());
    }

    public static PreliminaryAssessmentResponse mapPreliminary(RegistrationUsage registration)
    {

        return PreliminaryAssessmentResponse.builder()
                .enterpriseName(registration.getEnterpriseName())
                .udyamRegNumber(registration.getUdyamRegNumber())
                .enterpriseCategory(registration.getEnterpriseCategory())
                .district(registration.getDistrict())
                .mandal(registration.getMandal())
                .address(registration.getAddress())
                .natureOfActivity(registration.getNatureOfActivity())
                .existingCredit(registration.getExistingCredit())
                .creditFacilityDetails(mapCreditFacilityDetailsUsage(registration.getCreditFacilityDetailsUsages()))
                .gstNumber(registration.getGstNumber())
                .typeOfProduct(registration.getTypeOfProduct())
                .productUsage(registration.getProductUsage())
                .problemsFaced(registration.getProblemsFaced())
                .expectedSolution(registration.getExpectedSolution())
                .riskCategories(mapStressScore(registration.getStressScore()))
                .riskCategoryScore(registration.getRiskCategoryScore())
                .observations(registration.getObservations())
                .status(registration.getStatus())
                .build();
    }

}
