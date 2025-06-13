package com.metaverse.tihcl.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "unit_visit")
public class UnitVisit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "unit_visit_id")
	private Long unutVisitId;

	@Column(name = "visited_by")
	private String visitedBy;

	@Column(name = "date_and_time_of_visit")
	private Date dateAndTimeOfVisit;

	@Column(name = "name_of_the_person_met_and_designation")
	private String nameOfThePersonMetAndDesignation;

	@Column(name = "select_land_details")
	private String selectLandDetails;

	@Column(name = "factory_address")
	private String factoryAddress;

	@Column(name = "is_same_as_actory_ddress")
	private Boolean isSameAsFactoryAddress;

	@Column(name = "register_address")
	private String registerAddress;

	@Column(name = "is_upgradation_required")
	private Boolean isUpgradationRequired;

	@Column(name = "is_machinery_properly_aligned")
	private Boolean isMachineryProperlyAligned;

	@Column(name = "is_company_name_board")
	private Boolean isCompanyNameBoard;

	@Column(name = "is_financed_bank_name_board")
	private Boolean isFinancedBankNameBoard;

	// staff at the time of visit

	@Column(name = "office_staff")
	private Integer officeStaff;

	@Column(name = "factory_workers")
	private Integer factoryWorkers;

	@Column(name = "temporary_workers")
	private Integer temporaryWorkers;

	@Column(name = "is_emp_attendance_register")
	private Boolean isEmpAttendanceRegister;

	@Column(name = "inconsistencies_with_people_working")
	private String inconsistenciesWithPeopleWorking;

	@Column(name = "products_mfg_and_sold")
	private String productsMfgAndSold;

	@Column(name = "seasonal_or_throughtout_year")
	private String seasonalOrThroughtoutYear;

	@Column(name = "no_of_shifts")
	private Double noOfShifts;

	@Column(name = "is_stocks_stored_property")
	private Boolean isStocksStoredProperty;

	@Column(name = "is_adequate_storage_capacity")
	private Boolean isAdequateStorageCapacity;

//		stocks record
	@Column(name = "stocks_maintaned")
	private String stocksMaintaned;

	@Column(name = "is_uptodate")
	private String isUptoDate;

	@Column(name = "value_of_the_stock")
	private Double valueOfTheStock;

	@Column(name = "raw_materials")
	private String rawMaterials;

	@Column(name = "work_in_progress")
	private String workInProgress;

	@Column(name = "finished_goods")
	private String finishedGoods;

	@Column(name = "max_production_in_unit")
	private Double maxProductionInUnit;

	@Column(name = "min_production_in_unit")
	private Double minProductionInUnit;

	@Column(name = "current_production_in_unit")
	private Double currentProductionInUnit;

	@Column(name = "cost_per_unitl")
	private Double costPerUnit;

	@Column(name = "selling_price_per_unit")
	private Double sellingPricePerUnit;

	@Column(name = "profit_margin")
	private Double profitMargin;

	// Electricity Bill

	@Column(name = "recent_consumption")
	private Double recentConsumption;

	@Column(name = "max_consumption")
	private Double maxConsumption;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unitVisit", orphanRemoval = true)
	private List<FactoryDetails> factoryDetails;

	@Column(name = "created_on", insertable = true, updatable = false)
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "updated_on", insertable = false, updatable = true)
	@UpdateTimestamp
	private Date updatedOn;

}
