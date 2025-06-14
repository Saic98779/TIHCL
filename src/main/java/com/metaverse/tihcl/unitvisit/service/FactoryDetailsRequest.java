package com.metaverse.tihcl.unitvisit.service;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FactoryDetailsRequest {

	private String typesOfMachine;

	private String purpose;

	private Integer noOfMachines;

	private Double costOfMachinePurchased;

	private String currentCondition;

	private Integer valueOfMachinery;
}
