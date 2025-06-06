package com.metaverse.tihcl.registration.repository;

import com.metaverse.tihcl.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    Registration findByContactNumber(Long contactNumber);
}
