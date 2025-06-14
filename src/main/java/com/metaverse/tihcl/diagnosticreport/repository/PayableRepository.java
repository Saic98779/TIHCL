package com.metaverse.tihcl.diagnosticreport.repository;

import com.metaverse.tihcl.model.Payable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayableRepository extends JpaRepository<Payable, Long> {
}