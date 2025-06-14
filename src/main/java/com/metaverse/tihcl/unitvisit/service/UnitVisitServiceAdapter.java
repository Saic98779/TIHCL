

package com.metaverse.tihcl.unitvisit.service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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
		if(request == null) {
		     return	TihclResponse.builder().message("FAILURE").status(400).build();
		}else {
			UnitVisit save = unitVisitRepo.save(UnitVisitRequestMapper.convertDtoToEntity(request));
		    return 	TihclResponse.builder().message("SUCCESS").status(201).data(UnitVisitResponseMapper.convertEntityToDto(save)).build();
		}		
	}

	@Override
	public TihclResponse fetchingUnitVistData() {

		List<UnitVisitResponse>  fetchedAllUnitData =  unitVisitRepo.findAll()
				                                      .stream()
				                                      .map(UnitVisitResponseMapper::convertEntityToDto)
				                                      .toList();
        return  ((fetchedAllUnitData != null) ? TihclResponse.builder().status(200).message("SUCCESS").data(fetchedAllUnitData).build() : TihclResponse.builder().status(400).message("FAILURE").data("No Unit Visit Data").build());
	}

	@Override
	@Modifying
	@Transactional
	public TihclResponse updateUnitVisitRecord(Long id, UnitVisitRequest request) {

		 if(unitVisitRepo.existsById(id)){
			 Optional<UnitVisit> unitVisit = unitVisitRepo.findById(id);
            if(unitVisit.isPresent()) {
				UnitVisit unitVisitUpdatedData = UnitVisitUpdation.updatingUnitVisit(unitVisit.get(), request);
				unitVisitRepo.save(unitVisitUpdatedData);
				return TihclResponse.builder().message("Updated Successfully")
						.status(205).build();
			}else {
				return  TihclResponse.builder().message("Can't found this "+id+" for unit visit").status(400).build();
			}
		 }else {
			 return  TihclResponse.builder().message("Can't found this "+id+" for unit visit").status(400).build();
		 }
	}

	@Override
	@Modifying
	@Transactional
	public TihclResponse deleteByidUnitVist(Long id) {
		if(unitVisitRepo.existsById(id)) {
			unitVisitRepo.deleteById(id);
			return TihclResponse.builder().status(204).data("Deleted Successfully").build();
		}
		return TihclResponse.builder().status(400).message(id+" Doesn't Existed").build();
	}

	@Override
	public TihclResponse fetchingUnitVistById(Long id) {
		Optional<UnitVisit> unitVisitById =  unitVisitRepo.findById(id);
		if(unitVisitById.isPresent()){
		      UnitVisitResponse response = UnitVisitResponseMapper.convertEntityToDto(unitVisitById.get());
		      return TihclResponse.builder().data(response).message(id+" with fetched unit visit data.").status(200).build();
		}
		return TihclResponse.builder().message(id+" not found.").status(400).data("no data").build();
	}
}
