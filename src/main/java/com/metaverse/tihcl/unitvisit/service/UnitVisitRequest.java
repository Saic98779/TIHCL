package com.metaverse.tihcl.unitvisit.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UnitVisitRequest {

	private String visitedBy;
	
	private String dateOfVisit;

	private String timeOfVisit;
	
	private String nameOfThePerson;

	private String designation;
	
	private String selectLandDetails;
	
	private String factoryAddress;
	
	private Boolean isSameAsFactoryAddress;	
	
	private String registerAddress;

	private Boolean isUpgradationRequired;
	
	private Boolean isMachineryProperlyAligned;

	private Boolean isCompanyNameBoard;
	
	private Boolean isFinancedBankNameBoard;

	private Integer officeStaff;//staff at the time of visit
	
	private Integer factoryWorkers;
	
	private Integer temporaryWorkers;
	
	private Boolean isEmpAttendanceRegister;
	
	private String  inconsistenciesWithPeopleWorking;
	
	private String productsMfgAndSold;
	
	private String seasonalOrThroughtoutYear;
	
	private Double noOfShifts;
	
	private Boolean isStocksStoredProperty;

	private Boolean isAdequateStorageCapacity;

	private String stocksMaintaned;//	stocks record
	
	private Boolean isUptoDate;

	private Double valueOfTheStock;
	
	private String rawMaterials;
	
	private String workInProgress;
		
	private String finishedGoods;
	
	private Double maxProductionInUnit;
	
	private Double minProductionInUnit;
	
	private Double currentProductionInUnit;
	
	private Double costPerUnit;
	
	private Double sellingPricePerUnit;
	
	private Double profitMargin;

	private Double recentConsumption;//Electricity Bill
	
	private Double maxConsumption;
	
	private List<FactoryDetailsRequest> factoryDetails;
}
