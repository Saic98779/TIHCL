package com.metaverse.tihcl.registration.repository;

import com.metaverse.tihcl.model.Registration;
import com.metaverse.tihcl.model.RegistrationUsage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationUsageRepo extends JpaRepository<RegistrationUsage,Long> {
    RegistrationUsage findByContactNumber(Long contactNumber);

    Optional<RegistrationUsage> findByApplicationNo(String applicationNo);
}
