package com.metaverse.tihcl.unitvisit.service;

import java.util.List;
import java.util.stream.Collectors;

import com.metaverse.tihcl.common.util.DateUtil;
import com.metaverse.tihcl.model.FactoryDetails;
import com.metaverse.tihcl.model.UnitVisit;

public class UnitVisitRequestMapper {

    public static UnitVisit convertDtoToEntity(UnitVisitRequest dto) {

        // First convert child entities
         List<FactoryDetails> factoryData = dto.getFactoryDetails()
                .stream()
                .map(childDto -> FactoryDetails.builder()
                        .typesOfMachine(childDto.getTypesOfMachine())
                        .purpose(childDto.getPurpose())
                        .noOfMachines(childDto.getNoOfMachines())
                        .costOfMachinePurchased(childDto.getCostOfMachinePurchased())
                        .currentCondition(childDto.getCurrentCondition())
                        .valueOfMachinery(childDto.getValueOfMachinery())
                        .build())
                .collect(Collectors.toList());
         

         
         
        // Build parent entity
        UnitVisit unitVisit = UnitVisit.builder()
                .visitedBy(dto.getVisitedBy())
                .dateAndTimeOfVisit( DateUtil.stringToDate(dto.getDateAndTimeOfVisit()))
                .nameOfThePersonMetAndDesignation(dto.getNameOfThePersonMetAndDesignation())
                .selectLandDetails(dto.getSelectLandDetails())
                .factoryAddress(dto.getFactoryAddress())
                .isSameAsFactoryAddress(dto.getIsSameAsFactoryAddress())
                .registerAddress(dto.getRegisterAddress())
                .isUpgradationRequired(dto.getIsUpgradationRequired())
                .isMachineryProperlyAligned(dto.getIsMachineryProperlyAligned())
                .isCompanyNameBoard(dto.getIsCompanyNameBoard())
                .isFinancedBankNameBoard(dto.getIsFinancedBankNameBoard())
                .officeStaff(dto.getOfficeStaff())
                .factoryWorkers(dto.getFactoryWorkers())
                .temporaryWorkers(dto.getTemporaryWorkers())
                .isEmpAttendanceRegister(dto.getIsEmpAttendanceRegister())
                .inconsistenciesWithPeopleWorking(dto.getInconsistenciesWithPeopleWorking())
                .productsMfgAndSold(dto.getProductsMfgAndSold())
                .seasonalOrThroughtoutYear(dto.getSeasonalOrThroughtoutYear())
                .noOfShifts(dto.getNoOfShifts())
                .isStocksStoredProperty(dto.getIsStocksStoredProperty())
                .isAdequateStorageCapacity(dto.getIsAdequateStorageCapacity())
                .stocksMaintaned(dto.getStocksMaintaned())
                .isUptoDate(dto.getIsUptoDate())
                .valueOfTheStock(dto.getValueOfTheStock())
                .rawMaterials(dto.getRawMaterials())
                .workInProgress(dto.getWorkInProgress())
                .finishedGoods(dto.getFinishedGoods())
                .maxProductionInUnit(dto.getMaxProductionInUnit())
                .minProductionInUnit(dto.getMinProductionInUnit())
                .currentProductionInUnit(dto.getCurrentProductionInUnit())
                .costPerUnit(dto.getCostPerUnit())
                .sellingPricePerUnit(dto.getSellingPricePerUnit())
                .profitMargin(dto.getProfitMargin())
                .recentConsumption(dto.getRecentConsumption())
                .maxConsumption(dto.getMaxConsumption())
                .factoryDetails(factoryData)
                .build();

        // Set the reverse mapping
        factoryData.forEach(f -> f.setUnitVisit(unitVisit));

        return unitVisit;
    }
}
