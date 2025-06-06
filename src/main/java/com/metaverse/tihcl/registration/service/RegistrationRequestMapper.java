package com.metaverse.tihcl.registration.service;

import com.metaverse.tihcl.common.util.DateUtil;
import com.metaverse.tihcl.model.Registration;
import com.metaverse.tihcl.model.CreditFacilityDetails;
import java.util.stream.Collectors;

public class RegistrationRequestMapper {

    public static Registration mapRegistration(RegistrationRequest request) {
        Registration.RegistrationBuilder registrationBuilder = Registration.builder()
                .enterpriseName(request.getEnterpriseName())
                .promoterName(request.getPromoterName())
                .constitution(request.getConstitution())
                .productionDate(DateUtil.stringToDate(request.getProductionDate()))
                .udyamRegNumber(request.getUdyamRegNumber())
                .contactNumber(request.getContactNumber())
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
    public static CreditFacilityDetails mapCreditFacilityDetails(CreditFacilityDetailsRequest request) {
        return CreditFacilityDetails.builder()
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
}
