package com.metaverse.tihcl.registration.service;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.exceptions.DataException;
import com.metaverse.tihcl.model.CreditFacilityDetails;
import com.metaverse.tihcl.model.Registration;
import com.metaverse.tihcl.registration.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegistrationServiceAdepter implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Override
    public TihclResponse saveRegistration(RegistrationRequest request) throws DataException {
        Registration registration;
        if (request.getRegistrationId() == null) {
         if(registrationRepository.findByContactNumber(request.getContactNumber()) != null)
                return TihclResponse.builder().message(request.getContactNumber() + " This Number is already exists").status(400).build();
         registration = RegistrationRequestMapper.mapRegistration(request);
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
    public TihclResponse getAllRegistrations() {
        List<Registration> registrationList = registrationRepository.findAll();
        if (registrationList.isEmpty())
            return TihclResponse.builder().message("No registrations found in the system.").status(400).build();
        List<RegistrationResponse> responseList = registrationList.stream().map(RegistrationResponseMapper::map).collect(Collectors.toList());
        return TihclResponse.builder().message("Success").status(200).data(responseList).build();
    }
}
