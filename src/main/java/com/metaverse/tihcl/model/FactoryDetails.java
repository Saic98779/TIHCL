package com.metaverse.tihcl.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "factory_details")
public class FactoryDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sno")
	@SequenceGenerator(name = "sno",initialValue = 1,allocationSize = 1)
	@Column(name = "factory_id")
	private Long id;
	
	@Column(name = "types_of_machine")
	private String typesOfMachine;
	
	@Column(name = "purpose")
	private String purpose;
	
	@Column(name = "no_of_machines")
	private Integer noOfMachines;
	
	@Column(name = "cost_of_machine_purchased")
	private Double costOfMachinePurchased;
	
	@Column(name = "current_condition")
	private String currentCondition;
	
	@Column(name = "value_of_machinery")
	private Integer valueOfMachinery;
	
	@ManyToOne
	@JoinColumn(name = "unit_visit_id")
	private UnitVisit unitVisit;
	
	@Column(name = "created_on", insertable = true, updatable = false)
    @CreationTimestamp
    private Date createdOn;

	@Column(name = "updated_on", insertable = false, updatable = true)
	@UpdateTimestamp
    private Date updatedOn;
}