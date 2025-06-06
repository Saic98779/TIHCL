package com.metaverse.tihcl.districtswithmandals.service;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.model.District;
import com.metaverse.tihcl.model.Mandal;

import java.util.List;

public interface DistrictService {
    TihclResponse saveDistrict(DistrictRequest districtRequest);
    TihclResponse getAllDistricts();
    TihclResponse getAllMandalOfDistrict(Integer id);
    TihclResponse getDistrictById(Integer id);
    TihclResponse getAllMandals();

    List<District> getAllDistrictsEntity();
    List<Mandal> getAllMandalsEntity();

    Mandal getMandalById(Integer id);
}
