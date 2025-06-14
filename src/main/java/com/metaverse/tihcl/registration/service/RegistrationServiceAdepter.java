package com.metaverse.tihcl.registration.service;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.exceptions.DataException;
import com.metaverse.tihcl.model.CreditFacilityDetails;
import com.metaverse.tihcl.model.Registration;
<<<<<<< HEAD
import com.metaverse.tihcl.model.RegistrationStatus;
=======
import com.metaverse.tihcl.registration.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
>>>>>>> 6515833082fe9660e45973eebef87302a238bf12
import com.metaverse.tihcl.model.RegistrationUsage;
import com.metaverse.tihcl.registration.repository.CreditFacilityDetailsRepository;
import com.metaverse.tihcl.registration.repository.RegistrationRepository;
import com.metaverse.tihcl.registration.repository.RegistrationStatusRepository;
import com.metaverse.tihcl.registration.repository.RegistrationUsageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegistrationServiceAdepter implements RegistrationService {
<<<<<<< HEAD
    @Autowired
    RegistrationRepository registrationRepository;
=======

    private final RegistrationRepository registrationRepository;

>>>>>>> 6515833082fe9660e45973eebef87302a238bf12
    @Autowired
    RegistrationUsageRepo registrationUsageRepo;
    @Autowired
    CreditFacilityDetailsRepository creditFacilityDetailsRepo;
    @Autowired
    RegistrationStatusRepository registrationStatusRepo;

    @Override
    public TihclResponse saveRegistration(RegistrationRequest request) throws DataException {
        Registration registration;
        if (request.getRegistrationId() == null) {
<<<<<<< HEAD
            if (registrationRepository.findByContactNumber(request.getContactNumber()) != null)
                return TihclResponse.builder().message(request.getContactNumber() + " This Contact Number is already exists").status(400).build();
            String applicationNo = "TH" + ((int) (Math.random() * 900000) + 10000);
            if (registrationRepository.existsByApplicationNo(applicationNo))
                applicationNo = "TH" + ((int) (Math.random() * 900000) + 100000);
            registration = RegistrationRequestMapper.mapRegistration(request, applicationNo);
=======
         if(registrationRepository.findByContactNumber(request.getContactNumber()) != null)

         return TihclResponse.builder().message(request.getContactNumber() + " This Contact Number is already exists").status(400).build();
         String applicationNo="TH"+((int)(Math.random() * 900000) + 10000);
         if(registrationRepository.existsByApplicationNo(applicationNo))
             applicationNo="TH"+((int)(Math.random() * 900000) + 100000);
            registration = RegistrationRequestMapper.mapRegistration(request,applicationNo);
>>>>>>> 6515833082fe9660e45973eebef87302a238bf12
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
        registrationUsageRepo.save(RegistrationRequestMapper.mapRegistrationUsage(request, registration.getApplicationNo()));
        registrationStatusRepo.save(RegistrationStatus.builder()
                .status(registration.getStatus())
                .contactNumber(registration.getContactNumber())
                .applicationNo(registration.getApplicationNo())
                .build());
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


<<<<<<< HEAD
    @Override
=======
>>>>>>> 6515833082fe9660e45973eebef87302a238bf12
    public TihclResponse getRegistrationByMobilNo(Long mobileNo) throws DataException {
        RegistrationUsage registration = registrationUsageRepo.findByContactNumber(mobileNo);
        if (registration == null)
            return TihclResponse.builder().message("No Registrations found").status(400).build();
        return TihclResponse.builder().message("Success").status(200)
                .data(registration).build();

    }

    @Override
    public TihclResponse getAllRegistrations() throws DataException {
        List<Registration> registrationList = registrationRepository.findAll();
        if (registrationList.isEmpty())
            return TihclResponse.builder().message("No registrations found ").status(400).build();
        List<RegistrationResponse> responseList = registrationList.stream().map(RegistrationResponseMapper::map).collect(Collectors.toList());
        return TihclResponse.builder().message("Success").status(200).data(responseList).build();
    }

    @Override
    public TihclResponse savePreliminaryAssessment(PreliminaryAssessmentRequest request, String applicationNo) throws DataException {
        RegistrationUsage registrationUsage=registrationUsageRepo.findByApplicationNo(applicationNo)
                .orElseThrow(() -> new DataException(
                        "Registration not found fot this application number" + applicationNo,
                        "REGISTRATION_NOT_FOUND",
                        400
                ));
        RegistrationRequestMapper.mapPreliminary(request,registrationUsage);
        registrationUsageRepo.save(registrationUsage);
        return TihclResponse.builder()
                .message("Success")
                .status(200)
                .data(RegistrationResponseMapper.mapPreliminary(registrationUsageRepo.save(registrationUsage)))
                .build();
    }
}
