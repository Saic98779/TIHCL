package com.metaverse.tihcl.diagnosticreport.repository;

import com.metaverse.tihcl.model.OperationalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationalStatusRepository extends JpaRepository<OperationalStatus, Long> {
}
