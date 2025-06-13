package com.metaverse.tihcl.unitvisit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metaverse.tihcl.model.UnitVisit;

@Repository
public interface UnitVisitRepo extends JpaRepository<UnitVisit, Integer> {

}
