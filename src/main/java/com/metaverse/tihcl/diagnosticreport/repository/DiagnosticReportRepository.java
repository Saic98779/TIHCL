package com.metaverse.tihcl.diagnosticreport.repository;

import com.metaverse.tihcl.model.DiagnosticReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticReportRepository extends JpaRepository<DiagnosticReport, Long> {
}

