package com.metaverse.tihcl.districtswithmandals.service;


import com.metaverse.tihcl.model.District;
import org.springframework.stereotype.Component;

@Component
public class DistrictResponceMapper {

    public static DistrictResponse map(District district)
    {
       DistrictResponse response =  DistrictResponse.builder()
                .districtId(district.getDistrictId())
                .districtName(district.getDistrictName())

                .build();

        return response;
    }
}
