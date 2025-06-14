package com.metaverse.tihcl.diagnosticreport.repository;

import com.metaverse.tihcl.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
