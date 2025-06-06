package com.metaverse.tihcl.districtswithmandals.controller;


import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.districtswithmandals.service.DistrictRequest;
import com.metaverse.tihcl.districtswithmandals.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @PostMapping("/district/save")
    public TihclResponse saveDistrict(@RequestBody DistrictRequest districtRequest)
    {
        return districtService.saveDistrict(districtRequest);
    }
    @GetMapping("/getAllDistricts")
    public TihclResponse getAllDistrict()
    {
        return districtService.getAllDistricts();
    }
    @GetMapping("/districtsById/{id}")
    public TihclResponse getAllDistrict(@PathVariable Integer id)
    {
        return districtService.getDistrictById(id);
    }
    @GetMapping("/getAllmandalsOfDistrictsById/{id}")
    public TihclResponse getAllMandalOfDistrict(@PathVariable Integer id)
    {
        return districtService.getAllMandalOfDistrict(id);
    }

}
