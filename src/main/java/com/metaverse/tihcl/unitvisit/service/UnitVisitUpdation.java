package com.metaverse.tihcl.unitvisit.service;

import com.metaverse.tihcl.model.FactoryDetails;
import com.metaverse.tihcl.model.UnitVisit;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class UnitVisitUpdation {

    public static UnitVisit  updatingUnitVisit(UnitVisit unitVisit,UnitVisitRequest request){

            unitVisit.setVisitedBy((request.getVisitedBy()!= null) ? request.getVisitedBy() :unitVisit.getVisitedBy());
            unitVisit.setDateOfVisit(request.getDateOfVisit() != null ? LocalDate.parse(request.getDateOfVisit()) : unitVisit.getDateOfVisit());
            unitVisit.setTimeOfVisit((request.getTimeOfVisit() != null) ? LocalTime.parse(request.getTimeOfVisit()) : unitVisit.getTimeOfVisit());
            unitVisit.setNameOfThePerson((request.getNameOfThePerson() != null) ? request.getNameOfThePerson() : unitVisit.getNameOfThePerson());
            unitVisit.setDesignation((request.getDesignation()!= null) ? request.getDesignation() : unitVisit.getDesignation());
            unitVisit.setSelectLandDetails((request.getSelectLandDetails() != null) ? request.getSelectLandDetails() : unitVisit.getSelectLandDetails());
            unitVisit.setFactoryAddress((request.getFactoryAddress() != null) ? request.getFactoryAddress() : unitVisit.getFactoryAddress());
            unitVisit.setIsSameAsFactoryAddress((request.getIsSameAsFactoryAddress()!=null) ? request.getIsSameAsFactoryAddress() : unitVisit.getIsSameAsFactoryAddress());
            unitVisit.setRegisterAddress((request.getRegisterAddress()!= null)? request.getRegisterAddress() : unitVisit.getRegisterAddress());
            unitVisit.setIsUpgradationRequired((request.getIsUpgradationRequired()!= null)? request.getIsUpgradationRequired(): unitVisit.getIsUpgradationRequired());
            unitVisit.setIsMachineryProperlyAligned((request.getIsMachineryProperlyAligned()!= null) ? request.getIsMachineryProperlyAligned() : unitVisit.getIsMachineryProperlyAligned());
            unitVisit.setIsCompanyNameBoard((request.getIsCompanyNameBoard() != null) ? request.getIsCompanyNameBoard() : unitVisit.getIsCompanyNameBoard());
            unitVisit.setIsFinancedBankNameBoard((request.getIsFinancedBankNameBoard() != null) ? request.getIsFinancedBankNameBoard() : unitVisit.getIsFinancedBankNameBoard());
            unitVisit.setOfficeStaff((request.getOfficeStaff()!=null) ? request.getOfficeStaff() : unitVisit.getOfficeStaff());
            unitVisit.setFactoryWorkers((request.getFactoryWorkers()!=null) ? request.getFactoryWorkers() : unitVisit.getFactoryWorkers());
            unitVisit.setTemporaryWorkers((request.getTemporaryWorkers()!= null) ? request.getTemporaryWorkers() : unitVisit.getTemporaryWorkers());
            unitVisit.setIsEmpAttendanceRegister((request.getIsEmpAttendanceRegister()!= null) ? request.getIsEmpAttendanceRegister() : unitVisit.getIsEmpAttendanceRegister());
            unitVisit.setInconsistenciesWithPeopleWorking((request.getInconsistenciesWithPeopleWorking()!=null) ? request.getInconsistenciesWithPeopleWorking() : unitVisit.getInconsistenciesWithPeopleWorking());
            unitVisit.setProductsMfgAndSold((request.getProductsMfgAndSold()!= null) ? request.getProductsMfgAndSold() : unitVisit.getProductsMfgAndSold());
            unitVisit.setSeasonalOrThroughtoutYear((request.getSeasonalOrThroughtoutYear()!=null) ? request.getSeasonalOrThroughtoutYear() : unitVisit.getSeasonalOrThroughtoutYear());
            unitVisit.setNoOfShifts((request.getNoOfShifts()!=null) ? request.getNoOfShifts() : unitVisit.getNoOfShifts());
            unitVisit.setIsStocksStoredProperty((request.getIsStocksStoredProperty()!=null) ? request.getIsStocksStoredProperty() : unitVisit.getIsStocksStoredProperty());
            unitVisit.setIsAdequateStorageCapacity((request.getIsAdequateStorageCapacity()!= null) ? request.getIsAdequateStorageCapacity() : unitVisit.getIsAdequateStorageCapacity());
            unitVisit.setStocksMaintained((request.getStocksMaintaned()!=null) ? request.getStocksMaintaned() : unitVisit.getStocksMaintained());
            unitVisit.setIsUptoDate((request.getIsUptoDate()!=null) ? request.getIsUptoDate() : unitVisit.getIsUptoDate());
            unitVisit.setValueOfTheStock((request.getValueOfTheStock()!= null) ? request.getValueOfTheStock() : unitVisit.getValueOfTheStock());
            unitVisit.setRawMaterials((request.getRawMaterials()!=null) ? request.getRawMaterials() : unitVisit.getRawMaterials());
            unitVisit.setWorkInProgress((request.getWorkInProgress()!=null) ? request.getWorkInProgress() : unitVisit.getWorkInProgress());
            unitVisit.setFinishedGoods((request.getFinishedGoods()!=null) ? request.getFinishedGoods() : unitVisit.getFinishedGoods());
            unitVisit.setMaxProductionInUnit((request.getMaxProductionInUnit()!=null) ? request.getMaxProductionInUnit() : unitVisit.getMaxProductionInUnit());
            unitVisit.setMinProductionInUnit((request.getMinProductionInUnit()!=null) ? request.getMinProductionInUnit() : unitVisit.getMinProductionInUnit());
            unitVisit.setCurrentProductionInUnit((request.getCurrentProductionInUnit()!=null) ? request.getCurrentProductionInUnit() : unitVisit.getCurrentProductionInUnit());
            unitVisit.setCostPerUnit((request.getCostPerUnit()!=null) ? request.getCostPerUnit() : unitVisit.getCostPerUnit());
            unitVisit.setSellingPricePerUnit((request.getSellingPricePerUnit()!= null) ? request.getSellingPricePerUnit() : unitVisit.getSellingPricePerUnit());
            unitVisit.setProfitMargin((request.getProfitMargin()!=null) ? request.getProfitMargin() : unitVisit.getProfitMargin());
            unitVisit.setRecentConsumption((request.getRecentConsumption()!=null) ? request.getRecentConsumption(): unitVisit.getRecentConsumption());
            unitVisit.setMaxConsumption((request.getMaxConsumption() !=null) ? request.getMaxConsumption() : unitVisit.getMaxConsumption());

        List<FactoryDetails> factoryDetailsList = getFactoryDetails(unitVisit, request);

        unitVisit.setFactoryDetails(factoryDetailsList);

        return  unitVisit;
    }

    private static List<FactoryDetails> getFactoryDetails(UnitVisit unitVisit, UnitVisitRequest request) {
        List<FactoryDetailsRequest> factoryDetailsRequestList = request.getFactoryDetails();
        List<FactoryDetails> factoryDetailsList = unitVisit.getFactoryDetails();

        if(factoryDetailsRequestList != null || factoryDetailsRequestList.isEmpty()) {
            for (int i =0;i<factoryDetailsRequestList.size();i++) {
                  FactoryDetails details =  factoryDetailsList.get(i);
                  FactoryDetailsRequest  detailsRequest = factoryDetailsRequestList.get(i);

                  details.setTypesOfMachine((detailsRequest.getTypesOfMachine()!=null) ? detailsRequest.getTypesOfMachine() : details.getTypesOfMachine());
                  details.setPurpose((detailsRequest.getPurpose()!=null) ? detailsRequest.getPurpose() : details.getPurpose());
                  details.setNoOfMachines((detailsRequest.getNoOfMachines()!=null) ? detailsRequest.getNoOfMachines() : details.getNoOfMachines());
                  details.setCostOfMachinePurchased((detailsRequest.getCostOfMachinePurchased()!=null) ? detailsRequest.getCostOfMachinePurchased() : details.getCostOfMachinePurchased());
                  details.setCurrentCondition((detailsRequest.getCurrentCondition()!=null) ? detailsRequest.getCurrentCondition() : details.getCurrentCondition());
                  details.setValueOfMachinery((detailsRequest.getValueOfMachinery()!=null) ? detailsRequest.getValueOfMachinery() : details.getValueOfMachinery());
            }
        }
        return factoryDetailsList;
    }
}
