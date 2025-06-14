package com.metaverse.tihcl.diagnosticreport.repository;

import com.metaverse.tihcl.model.Shareholder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareholderRepository extends JpaRepository<Shareholder, Long> {
}
