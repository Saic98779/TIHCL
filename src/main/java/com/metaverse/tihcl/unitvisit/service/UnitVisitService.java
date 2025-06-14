package com.metaverse.tihcl.unitvisit.service;

import org.springframework.stereotype.Service;

import com.metaverse.tihcl.common.response.TihclResponse;

@Service
public interface UnitVisitService {
	
	 TihclResponse saveUnitVistData(UnitVisitRequest request);
	 TihclResponse fetchingUnitVistData();
	 TihclResponse updateUnitVisitRecord(Long id,UnitVisitRequest request);
	 TihclResponse deleteByidUnitVist(Long id);
	 TihclResponse fetchingUnitVistById(Long id);
}
