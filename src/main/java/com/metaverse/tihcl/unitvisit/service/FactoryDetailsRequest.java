package com.metaverse.tihcl.unitvisit.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FactoryDetailsRequest {

	private Integer factoryDetails;

	private String typesOfMachine;

	private String purpose;

	private Integer noOfMachines;

	private Double costOfMachinePurchased;

	private String currentCondition;

	private Integer valueOfMachinery;

}
