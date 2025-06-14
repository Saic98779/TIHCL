package com.metaverse.tihcl.diagnosticreport.repository;

import com.metaverse.tihcl.model.Receivable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivableRepository extends JpaRepository<Receivable, Long> {
}
