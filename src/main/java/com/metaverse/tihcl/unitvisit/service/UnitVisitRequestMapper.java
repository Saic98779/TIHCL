package com.metaverse.tihcl.unitvisit.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Collectors;

import com.metaverse.tihcl.model.FactoryDetails;
import com.metaverse.tihcl.model.UnitVisit;

public class UnitVisitRequestMapper {

    public static UnitVisit convertDtoToEntity(UnitVisitRequest dto) {

        return  UnitVisit.builder()
                .visitedBy(dto.getVisitedBy())
                .dateOfVisit(LocalDate.parse(dto.getDateOfVisit()))
                .timeOfVisit(LocalTime.parse(dto.getTimeOfVisit()))
                .nameOfThePerson(dto.getNameOfThePerson())
                .designation(dto.getDesignation())
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
                .stocksMaintained(dto.getStocksMaintaned())
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
                .factoryDetails(dto.getFactoryDetails()
                        .stream()
                        .map(childDto -> FactoryDetails.builder()
                                .typesOfMachine(childDto.getTypesOfMachine())
                                .purpose(childDto.getPurpose())
                                .noOfMachines(childDto.getNoOfMachines())
                                .costOfMachinePurchased(childDto.getCostOfMachinePurchased())
                                .currentCondition(childDto.getCurrentCondition())
                                .valueOfMachinery(childDto.getValueOfMachinery())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}