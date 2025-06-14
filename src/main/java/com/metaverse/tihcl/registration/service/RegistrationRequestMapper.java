package com.metaverse.tihcl.registration.service;

import com.metaverse.tihcl.common.util.DateUtil;
import com.metaverse.tihcl.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationRequestMapper {
    private static final String STATUS = "Pending";

    public static Registration mapRegistration(RegistrationRequest request, String applicationNo) {
        Registration.RegistrationBuilder registrationBuilder = Registration.builder()
                .enterpriseName(request.getEnterpriseName())
                .promoterName(request.getPromoterName())
                .constitution(request.getConstitution())
                .productionDate(DateUtil.stringToDate(request.getProductionDate()))
                .udyamRegNumber(request.getUdyamRegNumber())
                .contactNumber(request.getContactNumber())
                .altContactNumber(request.getAltContactNumber())
                .industrialPark(request.getIndustrialPark())
                .state(request.getState())
                .district(request.getDistrict())
                .mandal(request.getMandal())
                .email(request.getEmail())
                .address(request.getAddress())
                .enterpriseCategory(request.getEnterpriseCategory())
                .natureOfActivity(request.getNatureOfActivity())
                .sector(request.getSector())
                .operationStatus(request.getOperationStatus())
                .operatingSatisfactorily(request.getOperatingSatisfactorily())
                .operatingDifficulties(request.getOperatingDifficulties())
                .issueDate(request.getIssueDate() != null ? DateUtil.stringToDate(request.getIssueDate()) : null)
                .reasonForNotOperating(request.getReasonForNotOperating())
                .restartSupport(request.getRestartSupport())
                .restartIntent(request.getRestartIntent())
                .existingCredit(request.getExistingCredit())
                .unitStatus(request.getUnitStatus())
                .requiredCreditLimit(request.getRequiredCreditLimit())
                .investmentSubsidy(request.getInvestmentSubsidy())
                .totalAmountSanctioned(request.getTotalAmountSanctioned())
                .amountReleased(request.getAmountReleased())
                .amountToBeReleased(request.getAmountToBeReleased())
                .maintainingAccountBy(request.getMaintainingAccountBy())
                .status(STATUS)
                .applicationNo(applicationNo)
                .helpMsg(request.getHelpMsg());

        // Map the CreditFacilityDetails List
        if (request.getCreditFacilityDetails() != null) {
            registrationBuilder.creditFacilityDetails(
                    request.getCreditFacilityDetails().stream()
                            .map(RegistrationRequestMapper::mapCreditFacilityDetails)
                            .collect(Collectors.toList())
            );
        }

        return registrationBuilder.build();
    }
    public static RegistrationUsage mapRegistrationUsage(RegistrationRequest request, String applicationNo) {
        RegistrationUsage.RegistrationUsageBuilder registrationUsageBuilder = RegistrationUsage.builder()
                .enterpriseName(request.getEnterpriseName())
                .promoterName(request.getPromoterName())
                .constitution(request.getConstitution())
                .productionDate(DateUtil.stringToDate(request.getProductionDate()))
                .udyamRegNumber(request.getUdyamRegNumber())
                .contactNumber(request.getContactNumber())
                .altContactNumber(request.getAltContactNumber())
                .industrialPark(request.getIndustrialPark())
                .state(request.getState())
                .district(request.getDistrict())
                .mandal(request.getMandal())
                .email(request.getEmail())
                .address(request.getAddress())
                .enterpriseCategory(request.getEnterpriseCategory())
                .natureOfActivity(request.getNatureOfActivity())
                .sector(request.getSector())
                .operationStatus(request.getOperationStatus())
                .operatingSatisfactorily(request.getOperatingSatisfactorily())
                .operatingDifficulties(request.getOperatingDifficulties())
                .issueDate(request.getIssueDate() != null ? DateUtil.stringToDate(request.getIssueDate()) : null)
                .reasonForNotOperating(request.getReasonForNotOperating())
                .restartSupport(request.getRestartSupport())
                .restartIntent(request.getRestartIntent())
                .existingCredit(request.getExistingCredit())
                .unitStatus(request.getUnitStatus())
                .requiredCreditLimit(request.getRequiredCreditLimit())
                .investmentSubsidy(request.getInvestmentSubsidy())
                .totalAmountSanctioned(request.getTotalAmountSanctioned())
                .amountReleased(request.getAmountReleased())
                .amountToBeReleased(request.getAmountToBeReleased())
                .maintainingAccountBy(request.getMaintainingAccountBy())
                .status(STATUS)
                .applicationNo(applicationNo)
                .helpMsg(request.getHelpMsg());

        // Map the CreditFacilityDetails List
        if (request.getCreditFacilityDetails() != null) {
            registrationUsageBuilder.creditFacilityDetailsUsages(
                    request.getCreditFacilityDetails().stream()
                            .map(RegistrationRequestMapper::mapCreditFacilityDetailsUsage)
                            .collect(Collectors.toList())
            );
        }

        return registrationUsageBuilder.build();
    }

    public static CreditFacilityDetails mapCreditFacilityDetails(CreditFacilityDetailsRequest request) {
        return CreditFacilityDetails.builder()
                .bankName(request.getBankName())
                .limitSanctioned(request.getLimitSanctioned())
                .outstandingAmount(request.getOutstandingAmount())
                .overdueAmount(request.getOverdueAmount())
                .overdueDate(DateUtil.stringToDate(request.getOverdueDate()))
                .build();
    }
    public static CreditFacilityDetailsUsage mapCreditFacilityDetailsUsage(CreditFacilityDetailsRequest request) {
        return CreditFacilityDetailsUsage.builder()
                .bankName(request.getBankName())
                .limitSanctioned(request.getLimitSanctioned())
                .outstandingAmount(request.getOutstandingAmount())
                .overdueAmount(request.getOverdueAmount())
                .overdueDate(DateUtil.stringToDate(request.getOverdueDate()))
                .build();
    }



    public static void updateRegistrationFromRequest(Registration registration, RegistrationRequest request) {
        registration.setEnterpriseName(request.getEnterpriseName());
        registration.setPromoterName(request.getPromoterName());
        registration.setConstitution(request.getConstitution());
        registration.setProductionDate(DateUtil.stringToDate(request.getProductionDate()));
        registration.setUdyamRegNumber(request.getUdyamRegNumber());
        registration.setContactNumber(request.getContactNumber());
        registration.setIndustrialPark(request.getIndustrialPark());
        registration.setState(request.getState());
        registration.setDistrict(request.getDistrict());
        registration.setMandal(request.getMandal());
        registration.setEmail(request.getEmail());
        registration.setAddress(registration.getAddress());
        registration.setEnterpriseCategory(request.getEnterpriseCategory());
        registration.setNatureOfActivity(request.getNatureOfActivity());
        registration.setSector(request.getSector());
        registration.setOperationStatus(request.getOperationStatus());
        registration.setOperatingSatisfactorily(request.getOperatingSatisfactorily());
        registration.setOperatingDifficulties(request.getOperatingDifficulties());
        registration.setIssueDate(request.getIssueDate() != null ? DateUtil.stringToDate(request.getIssueDate()) : null);
        registration.setReasonForNotOperating(request.getReasonForNotOperating());
        registration.setRestartSupport(request.getRestartSupport());
        registration.setRestartIntent(request.getRestartIntent());
        registration.setExistingCredit(request.getExistingCredit());
        registration.setUnitStatus(request.getUnitStatus());
        registration.setRequiredCreditLimit(request.getRequiredCreditLimit());
        registration.setInvestmentSubsidy(request.getInvestmentSubsidy());
        registration.setTotalAmountSanctioned(request.getTotalAmountSanctioned());
        registration.setAmountReleased(request.getAmountReleased());
        registration.setAmountToBeReleased(request.getAmountToBeReleased());
        registration.setMaintainingAccountBy(request.getMaintainingAccountBy());
        registration.setHelpMsg(request.getHelpMsg());
    }

    /*public static void mapPreliminary(PreliminaryAssessmentRequest request, RegistrationUsage registration) {
        registration.getCreditFacilityDetailsUsages().clear();

        registration.setEnterpriseName(request.getEnterpriseName());
        registration.setUdyamRegNumber(request.getUdyamRegNumber());
        registration.setDistrict(request.getDistrict());
        registration.setMandal(request.getMandal());
        registration.setAddress(request.getAddress());
        registration.setEnterpriseCategory(request.getEnterpriseCategory());
        registration.setNatureOfActivity(request.getNatureOfActivity());
        registration.setGstNumber(request.getGstNumber());
        registration.setTypeOfProduct(request.getTypeOfProduct());
        registration.setProductUsage(request.getProductUsage());
        registration.setProblemsFaced(request.getProblemsFaced());
        registration.setExpectedSolution(request.getExpectedSolution());
        registration.setRiskCategoryScore(request.getRiskCategoryScore());
        registration.setObservations(request.getObservations());
        registration.setStatus(request.getStatus());
        registration.setCreditFacilityDetailsUsages(request.getCreditFacilityDetails()
                .stream().map(RegistrationRequestMapper::mapCreditFacilityDetailsUsage)
                .collect(Collectors.toList()));
        registration.setStressScore(request.getRiskCategories().stream()
                .map(RegistrationRequestMapper::mapStressScore).collect(Collectors.toList()));
//
    }*/

    public static StressScore mapStressScore(StressScoreRequest request) {
        return StressScore.builder()
                .issues(request.getIssue())
                .riskCategorisation(request.getRiskCategorisation())
                .build();
    }
    public static void mapPreliminary(PreliminaryAssessmentRequest request, RegistrationUsage registration) {
        registration.setEnterpriseName(request.getEnterpriseName());
        registration.setUdyamRegNumber(request.getUdyamRegNumber());
        registration.setEnterpriseCategory(request.getEnterpriseCategory());
        registration.setDistrict(request.getDistrict());
        registration.setMandal(request.getMandal());
        registration.setAddress(request.getAddress());
        registration.setNatureOfActivity(request.getNatureOfActivity());
        registration.setExistingCredit(request.getExistingCredit());
        registration.setGstNumber(request.getGstNumber());
        registration.setTypeOfProduct(request.getTypeOfProduct());
        registration.setProductUsage(request.getProductUsage());
        registration.setProblemsFaced(request.getProblemsFaced());
        registration.setExpectedSolution(request.getExpectedSolution());
        registration.setRiskCategoryScore(request.getRiskCategoryScore());
        registration.setObservations(request.getObservations());
        registration.setStatus(request.getStatus());
        updateCreditFacilityDetailsUsage(request.getCreditFacilityDetails(), registration);
        updateStressScores(request.getRiskCategories(), registration);
    }

    private static void updateStressScores(List<StressScoreRequest> requestList, RegistrationUsage registration) {
        if (registration.getStressScore() != null) {
            registration.getStressScore().clear(); // Orphan removal: deletes from DB
        } else {
            registration.setStressScore(new ArrayList<>());
        }

        for (StressScoreRequest dto : requestList) {
            StressScore entity = StressScore.builder()
                    .riskCategorisation(dto.getRiskCategorisation())
                    .issues(dto.getIssue())
                    .registrationUsage(registration) // maintain parent reference
                    .build();

            registration.getStressScore().add(entity);
        }
    }


    private static void updateCreditFacilityDetailsUsage(List<CreditFacilityDetailsRequest> requestList, RegistrationUsage registration) {
        if (registration.getCreditFacilityDetailsUsages() != null) {
            registration.getCreditFacilityDetailsUsages().clear();
        } else {
            registration.setCreditFacilityDetailsUsages(new ArrayList<>());
        }

        for (CreditFacilityDetailsRequest dto : requestList) {
            CreditFacilityDetailsUsage entity = CreditFacilityDetailsUsage.builder()
                    .bankName(dto.getBankName())
                    .limitSanctioned(dto.getLimitSanctioned())
                    .outstandingAmount(dto.getOutstandingAmount())
                    .overdueAmount(dto.getOverdueAmount())
                    .overdueDate(DateUtil.stringToDate(dto.getOverdueDate()))
                    .registrationUsage(registration) // maintain parent reference
                    .build();
            registration.getCreditFacilityDetailsUsages().add(entity);
        }
    }


}
