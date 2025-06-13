package com.metaverse.tihcl.unitvisit.service;

import java.util.List;

import com.metaverse.tihcl.model.FactoryDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UnitVisitResponse {
	
	
    private Long id;
	private String visitedBy;
	
	private String dateAndTimeOfVisit;
	
	private String nameOfThePersonMetAndDesignation;
	
	private String selectLandDetails;
	
	private String factoryAddress;
	
	private Boolean isSameAsFactoryAddress;	
	
	private String registerAddress;
	

	private Boolean isUpgradationRequired;
	
	private Boolean isMachineryProperlyAligned;
	private Boolean isCompanyNameBoard;
	
	private Boolean isFinancedBankNameBoard;
 	
	//staff at the time of visit
	
	private Integer officeStaff;
	
	private Integer factoryWorkers;
	
	private Integer temporaryWorkers;
	
	private Boolean isEmpAttendanceRegister;
	
	private String  inconsistenciesWithPeopleWorking;
	
	private String productsMfgAndSold;
	
	private String seasonalOrThroughtoutYear;
	
	private Double noOfShifts;
	
	private Boolean isStocksStoredProperty;
	
	
	private Boolean isAdequateStorageCapacity;
	
//	stocks record
	private String stocksMaintaned;
	
	private String isUptoDate;
	
	
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
	
	//Electricity Bill
	
	private Double recentConsumption;
	
	private Double maxConsumption;
	
	private List<FactoryDetailsResponse> factoryDetails;



}
