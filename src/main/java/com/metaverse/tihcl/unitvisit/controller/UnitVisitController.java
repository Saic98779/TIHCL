package com.metaverse.tihcl.unitvisit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.unitvisit.service.UnitVisitRequest;
import com.metaverse.tihcl.unitvisit.service.UnitVisitService;

@RestController
@RequestMapping(path = "/unitvisit")
public class UnitVisitController {
	
	@Autowired
	private UnitVisitService unitVisitservice;

	@PostMapping(path = "/save")
	public ResponseEntity<?> savingUnitVisitData(@RequestBody UnitVisitRequest request) {
		TihclResponse responseWithBodyCode = unitVisitservice.saveUnitVistData(request);
		return ResponseEntity.status(HttpStatusCode.valueOf(responseWithBodyCode.getStatus())).body(new ResponseMessage(responseWithBodyCode.getStatus(),responseWithBodyCode.getMessage(),responseWithBodyCode.getData()));
	}

	@GetMapping(path = "/fetchAll")
	public ResponseEntity<?> retrieveAllData() {
		TihclResponse fetchAllData = unitVisitservice.fetchingUnitVistData();
		return ResponseEntity.status(fetchAllData.getStatus()).body(new ResponseMessage(fetchAllData.getStatus(), fetchAllData.getMessage(), fetchAllData.getData()));
	}

	@GetMapping(path = "/fetch/{id}")
	public ResponseEntity<?> retrieveById(@PathVariable Long id) {
		TihclResponse fetchData = unitVisitservice.fetchingUnitVistById(id);
		return ResponseEntity.status(fetchData.getStatus()).body(new ResponseMessage(fetchData.getStatus(), fetchData.getMessage(), fetchData.getData()));
	}

    @PutMapping(path = "/update/{id}")
	public ResponseEntity<?> updateRecord(@PathVariable Long id,@RequestBody UnitVisitRequest request){
		TihclResponse response = unitVisitservice.updateUnitVisitRecord(id,request);
		return ResponseEntity.status(response.getStatus()).body(new ResponseMessage(response.getStatus(),response.getMessage(),""));
	}
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> deleteUnitVisit(@PathVariable Long id){
		if(id != null){
			TihclResponse response = unitVisitservice.deleteByidUnitVist(id);
			return  ResponseEntity.status(response.getStatus()).body(new ResponseMessage(response.getStatus(),response.getMessage(),""));
		}
		return ResponseEntity.status(400).body(id+" Doesn't Existed");
	}
}