package com.metaverse.tihcl.registration.repository;

import com.metaverse.tihcl.model.RegistrationStatus;
import com.metaverse.tihcl.model.RegistrationUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationStatusRepository extends JpaRepository<RegistrationStatus,Long> {
    RegistrationStatus findByContactNumber(Long mobileNo);
}
