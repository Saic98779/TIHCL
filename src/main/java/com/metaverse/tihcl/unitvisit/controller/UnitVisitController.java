package com.metaverse.tihcl.unitvisit.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.model.UnitVisit;
import com.metaverse.tihcl.unitvisit.service.UnitVisitRequest;
import com.metaverse.tihcl.unitvisit.service.UnitVisitRequestMapper;
import com.metaverse.tihcl.unitvisit.service.UnitVisitResponse;
import com.metaverse.tihcl.unitvisit.service.UnitVisitResponseMapper;
import com.metaverse.tihcl.unitvisit.service.UnitVisitService;

@RestController
@RequestMapping(path = "/unitvisit")
public class UnitVisitController {
	
	@Autowired
	private UnitVisitService unitVisitservice;
	
	
	
	@PostMapping(path = "/save")
	public ResponseEntity<?> savingUnitVistData(@RequestBody(required = true) UnitVisitRequest request) {
		
		TihclResponse responseWithBodyCode = unitVisitservice.saveUnitVistData(request);
		
		return ResponseEntity.status(HttpStatusCode.valueOf(responseWithBodyCode.getStatus())).body(new ResponseMessage(responseWithBodyCode.getStatus(),responseWithBodyCode.getMessage(),responseWithBodyCode.getData()));
	}

	
	
	@GetMapping(path = "/fetch")
	public ResponseEntity<?>  retreveAllData() {
		List<UnitVisit> fetchAllData = unitVisitservice.fetchingUnitVistData();
		List<UnitVisitResponse> collect = fetchAllData.stream().map(r -> UnitVisitResponseMapper.convertEntityToDto(r)).collect(Collectors.toList());

		return ResponseEntity.ofNullable(new ResponseMessage(200, "FETCHED", "Retreved all Unit Vistited Details" , collect));
	}
	
	
	

}










