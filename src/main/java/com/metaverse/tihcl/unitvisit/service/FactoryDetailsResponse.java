package com.metaverse.tihcl.unitvisit.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FactoryDetailsResponse {

		
	private Long id;

	private String typesOfMachine;

	private String purpose;

	private Integer noOfMachines;

	private Double costOfMachinePurchased;

	private String currentCondition;

	private Integer valueOfMachinery;

}
