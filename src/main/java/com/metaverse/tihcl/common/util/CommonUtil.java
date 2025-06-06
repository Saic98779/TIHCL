package com.metaverse.tihcl.common.util;

import com.metaverse.tihcl.model.District;
import com.metaverse.tihcl.model.Mandal;
import com.metaverse.tihcl.districtswithmandals.service.DistrictService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@AllArgsConstructor
@Slf4j
@Component
public class CommonUtil {

    @Autowired
    DistrictService districtService;


    public static Map<Integer, String> districtMap;
    public static Map<Integer, String> mandalMap;



    public void init() {
        List<District> districtList = districtService.getAllDistrictsEntity();
        districtMap = districtList.stream().collect(Collectors.toMap(dist -> dist.getDistrictId(), dist -> dist.getDistrictName()));

        List<Mandal> mandalList = districtService.getAllMandalsEntity();
        mandalMap = mandalList.stream().collect(Collectors.toMap(mandal -> mandal.getMandalId(), mandal -> mandal.getMandalName()));

       }


}
