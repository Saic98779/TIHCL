package com.metaverse.tihcl.registration.service;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.exceptions.DataException;

public interface RegistrationService {
    TihclResponse saveRegistration(RegistrationRequest request) throws DataException;
    TihclResponse getRegistrationById(Long id) throws DataException;
    TihclResponse getAllRegistrations() throws DataException;

}
