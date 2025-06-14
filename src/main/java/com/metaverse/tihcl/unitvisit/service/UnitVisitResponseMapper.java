package com.metaverse.tihcl.unitvisit.service;

import java.util.stream.Collectors;

import com.metaverse.tihcl.model.UnitVisit;

public class UnitVisitResponseMapper {

	public static UnitVisitResponse convertEntityToDto(UnitVisit unitVisit) {
	    return UnitVisitResponse.builder()
	    		.id(unitVisit.getUnitVisitId())
	            .visitedBy(unitVisit.getVisitedBy())
	            .dateOfVisit(String.valueOf(unitVisit.getDateOfVisit()))
				.timeOfVisit(String.valueOf(unitVisit.getTimeOfVisit()))
	            .nameOfThePerson(unitVisit.getNameOfThePerson())
				.designation(unitVisit.getDesignation())
	            .selectLandDetails(unitVisit.getSelectLandDetails())
	            .factoryAddress(unitVisit.getFactoryAddress())
	            .isSameAsFactoryAddress(unitVisit.getIsSameAsFactoryAddress())
	            .registerAddress(unitVisit.getRegisterAddress())
	            .isUpgradationRequired(unitVisit.getIsUpgradationRequired())
	            .isMachineryProperlyAligned(unitVisit.getIsMachineryProperlyAligned())
	            .isCompanyNameBoard(unitVisit.getIsCompanyNameBoard())
	            .isFinancedBankNameBoard(unitVisit.getIsFinancedBankNameBoard())
	            .officeStaff(unitVisit.getOfficeStaff())
	            .factoryWorkers(unitVisit.getFactoryWorkers())
	            .temporaryWorkers(unitVisit.getTemporaryWorkers())
	            .isEmpAttendanceRegister(unitVisit.getIsEmpAttendanceRegister())
	            .inconsistenciesWithPeopleWorking(unitVisit.getInconsistenciesWithPeopleWorking())
	            .productsMfgAndSold(unitVisit.getProductsMfgAndSold())
	            .seasonalOrThroughtoutYear(unitVisit.getSeasonalOrThroughtoutYear())
	            .noOfShifts(unitVisit.getNoOfShifts())
	            .isStocksStoredProperty(unitVisit.getIsStocksStoredProperty())
	            .isAdequateStorageCapacity(unitVisit.getIsAdequateStorageCapacity())
	            .stocksMaintained(unitVisit.getStocksMaintained())
	            .isUptoDate(unitVisit.getIsUptoDate())
	            .valueOfTheStock(unitVisit.getValueOfTheStock())
	            .rawMaterials(unitVisit.getRawMaterials())
	            .workInProgress(unitVisit.getWorkInProgress())
	            .finishedGoods(unitVisit.getFinishedGoods())
	            .maxProductionInUnit(unitVisit.getMaxProductionInUnit())
	            .minProductionInUnit(unitVisit.getMinProductionInUnit())
	            .currentProductionInUnit(unitVisit.getCurrentProductionInUnit())
	            .costPerUnit(unitVisit.getCostPerUnit())
	            .sellingPricePerUnit(unitVisit.getSellingPricePerUnit())
	            .profitMargin(unitVisit.getProfitMargin())
	            .recentConsumption(unitVisit.getRecentConsumption())
	            .maxConsumption(unitVisit.getMaxConsumption())
	            .factoryDetails(unitVisit.getFactoryDetails()
						.stream()
						.map(entity -> FactoryDetailsResponse.builder().id(entity.getId())
								.typesOfMachine(entity.getTypesOfMachine())
								.purpose(entity.getPurpose())
								.noOfMachines(entity.getNoOfMachines())
								.costOfMachinePurchased(entity.getCostOfMachinePurchased())
								.currentCondition(entity.getCurrentCondition())
								.valueOfMachinery(entity.getValueOfMachinery())
								.build())
						.collect(Collectors.toList()))
	            .build();
	}
}
