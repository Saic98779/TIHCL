

package com.metaverse.tihcl.unitvisit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.model.UnitVisit;
import com.metaverse.tihcl.unitvisit.repository.UnitVisitRepo;

@Service
public class UnitVisitServiceAdapter  implements UnitVisitService{

	@Autowired
	private UnitVisitRepo unitVisitRepo;

	@Override
	public TihclResponse saveUnitVistData(UnitVisitRequest request) {
		
		
		UnitVisit unitVisitdata;
       
		if(request == null) {
		 return	TihclResponse.builder().message("Don't pass Empty Data ").status(400).build();
		}else {
			UnitVisit save = unitVisitRepo.save(UnitVisitRequestMapper.convertDtoToEntity(request));
			
		return 	TihclResponse.builder()
				             .message("Created successfully")
				             .status(201)
				             .data(UnitVisitResponseMapper.convertEntityToDto(save))
				             .build();
		}		
	}

	

	@Override
	public List<UnitVisit> fetchingUnitVistData() {
		return unitVisitRepo.findAll();
	}

	
	
	
	
	
}
