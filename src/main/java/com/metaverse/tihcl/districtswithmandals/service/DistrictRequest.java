package com.metaverse.tihcl.districtswithmandals.service;

import com.metaverse.tihcl.model.Mandal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DistrictRequest {

    private Integer districtId;
    private String districtName;
    private Date createdOn;
    private Date updatedOn;
    private List<Mandal> mandals;

}
