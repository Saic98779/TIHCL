package com.metaverse.tihcl.registration.service;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.exceptions.DataException;
import com.metaverse.tihcl.model.CreditFacilityDetails;
import com.metaverse.tihcl.model.Registration;
import com.metaverse.tihcl.model.RegistrationUsage;
import com.metaverse.tihcl.registration.repository.CreditFacilityDetailsRepository;
import com.metaverse.tihcl.registration.repository.RegistrationRepository;
import com.metaverse.tihcl.registration.repository.RegistrationUsageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceAdepter implements RegistrationService {
    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    RegistrationUsageRepo registrationUsageRepo;
    @Autowired
    CreditFacilityDetailsRepository creditFacilityDetailsRepository;

    @Override
    @Transactional
    public TihclResponse saveRegistration(RegistrationRequest request) throws DataException {
        Registration registration;
        if (request.getRegistrationId() == null) {
         if(registrationRepository.findByContactNumber(request.getContactNumber()) != null)
         return TihclResponse.builder().message(request.getContactNumber() + " This Contact Number is already exists").status(400).build();
         String applicationNo="TH"+((int)(Math.random() * 900000) + 10000);
         if(registrationRepository.existsByApplicationNo(applicationNo))
             applicationNo="TH"+((int)(Math.random() * 900000) + 100000);
            registration = RegistrationRequestMapper.mapRegistration(request,applicationNo);
        } else {
            registration = registrationRepository.findById(request.getRegistrationId())
                    .orElseThrow(() -> new DataException(
                            "Registration not found fot this id " + request.getRegistrationId(),
                            "REGISTRATION_NOT_FOUND",
                            400
                    ));
            RegistrationRequestMapper.updateRegistrationFromRequest(registration, request);

        }
        if (Boolean.TRUE.equals(request.getExistingCredit()) && request.getCreditFacilityDetails() != null) {
            List<CreditFacilityDetails> creditDetailsList = request.getCreditFacilityDetails().stream()
                    .map(RegistrationRequestMapper::mapCreditFacilityDetails)
                    .toList();
            creditDetailsList.forEach(detail -> detail.setRegistration(registration));

            registration.getCreditFacilityDetails().clear();
            registration.getCreditFacilityDetails().addAll(creditDetailsList);
        }
        registrationUsageRepo.save(RegistrationRequestMapper.mapRegistrationUsage(registration));
        return TihclResponse.builder()
                .message("Registration added successfully")
                .status(200)
                .data(RegistrationResponseMapper.map(registrationRepository.save(registration)))
                .build();

    }


    @Override
    public TihclResponse getRegistrationById(Long id) throws DataException {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new DataException(
                        "Registration not found fot this id" + id,
                        "REGISTRATION_NOT_FOUND",
                        400
                ));
        return TihclResponse.builder().message("Success").status(200)
                .data(RegistrationResponseMapper.map(registration)).build();
    }

    @Override
    public TihclResponse getRegistrationByMobilNo(Long mobileNo) throws DataException {
        RegistrationUsage registration = registrationUsageRepo.findByContactNumber(mobileNo);
        if (registration == null)
            return TihclResponse.builder().message("No registrations found in the system.").status(400).build();
        return TihclResponse.builder().message("Success").status(200)
                .data(RegistrationResponseMapper.map(registration)).build();

    }

    @Override
    public TihclResponse getAllRegistrations() throws DataException {
        List<Registration> registrationList = registrationRepository.findAll();
        if (registrationList.isEmpty())
            return TihclResponse.builder().message("No registrations found ").status(400).build();
        List<RegistrationResponse> responseList = registrationList.stream().map(RegistrationResponseMapper::map).collect(Collectors.toList());
        return TihclResponse.builder().message("Success").status(200).data(responseList).build();
    }
}
