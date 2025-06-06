package com.metaverse.tihcl.registration.service;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.exceptions.DataException;
import com.metaverse.tihcl.model.Registration;

import java.util.List;

public interface RegistrationService {
    TihclResponse saveRegistration(RegistrationRequest request) throws DataException;
    TihclResponse getRegistrationById(Long id) throws DataException;
    TihclResponse getRegistrationByMobilNo(Long mobileNo) throws DataException;
    TihclResponse getAllRegistrations() throws DataException;

}
