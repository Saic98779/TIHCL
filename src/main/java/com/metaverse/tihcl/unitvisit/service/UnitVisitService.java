package com.metaverse.tihcl.unitvisit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.model.UnitVisit;


@Service
public interface UnitVisitService {
	
	 TihclResponse saveUnitVistData(UnitVisitRequest request);
	 List<UnitVisit> fetchingUnitVistData();

}
