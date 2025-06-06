package com.metaverse.tihcl.districtswithmandals.service;

import com.metaverse.tihcl.model.Mandal;
import org.springframework.stereotype.Component;

@Component
public class MandalResponceMapper {

    public static MandalResponse map(Mandal mandal)
    {
       MandalResponse response =  MandalResponse.builder()
                .mandalId(mandal.getMandalId())
                .mandalName(mandal.getMandalName())
                .build();

        return response;
    }
}
