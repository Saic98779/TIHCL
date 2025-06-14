package com.metaverse.tihcl.unitvisit.service;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UnitVisitResponse {

    private Long id;

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

	private Integer officeStaff;// from hear staff at the time of visit
	
	private Integer factoryWorkers;
	
	private Integer temporaryWorkers;
	
	private Boolean isEmpAttendanceRegister;
	
	private String  inconsistenciesWithPeopleWorking;
	
	private String productsMfgAndSold;
	
	private String seasonalOrThroughtoutYear;
	
	private Double noOfShifts;
	
	private Boolean isStocksStoredProperty;

	private Boolean isAdequateStorageCapacity;

	private String stocksMaintained;//	from hear stocks record

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
	
	private List<FactoryDetailsResponse> factoryDetails;
}