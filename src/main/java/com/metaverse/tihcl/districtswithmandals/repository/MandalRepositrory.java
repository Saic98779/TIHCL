package com.metaverse.tihcl.districtswithmandals.repository;

import com.metaverse.tihcl.model.Mandal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MandalRepositrory extends JpaRepository<Mandal,Integer> {
    @Query("SELECT m FROM Mandal m WHERE m.district.districtId = :districtId")
    List<Mandal> findByDistrictId(@Param("districtId") Integer districtId);


}
