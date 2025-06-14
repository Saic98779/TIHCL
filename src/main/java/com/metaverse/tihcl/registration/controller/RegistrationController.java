package com.metaverse.tihcl.registration.controller;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.common.util.RestControllerBase;
import com.metaverse.tihcl.exceptions.DataException;
<<<<<<< HEAD
import com.metaverse.tihcl.model.Registration;
=======
<<<<<<< HEAD
import com.metaverse.tihcl.registration.service.PreliminaryAssessmentRequest;
=======
>>>>>>> 6515833082fe9660e45973eebef87302a238bf12
>>>>>>> 543b7031cb6421f20a9619301c2ff47f89a2f099
import com.metaverse.tihcl.registration.service.RegistrationRequest;
import com.metaverse.tihcl.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;


    @PostMapping("/save")
    public ResponseEntity<?> saveRegistration(@RequestBody RegistrationRequest request) throws DataException {
        TihclResponse savedRegistration = null;
        try {
            savedRegistration = registrationService.saveRegistration(request);
        } catch (DataException exception) {
            return RestControllerBase.error(exception);
        }
        return ResponseEntity.ok(savedRegistration);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getRegistrationById(@PathVariable Long id) {
        TihclResponse registration = null;
        try {
            registration = registrationService.getRegistrationById(id);
        } catch (DataException exception) {
          return  RestControllerBase.error(exception);
        }
        return  ResponseEntity.ok(registration);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRegistration() {
        TihclResponse registration = null;
        try {
            registration = registrationService.getAllRegistrations();
        } catch (DataException exception) {
            return  RestControllerBase.error(exception);
        }
        return  ResponseEntity.ok(registration);
    }
    @GetMapping("/mobile/no/{mobileNo}")
    public ResponseEntity<?> getAllRegistration(@PathVariable Long mobileNo) {
        TihclResponse registration = null;
        try {
            registration = registrationService.getRegistrationByMobilNo(mobileNo);
        } catch (DataException exception) {
            return  RestControllerBase.error(exception);
        }
        return  ResponseEntity.ok(registration);
    }
    @PostMapping("/preliminary/save/{applicationNo}")
    public ResponseEntity<?> savePreliminaryAssessment(@RequestBody PreliminaryAssessmentRequest request,
                                                      @PathVariable String applicationNo) throws DataException {
        TihclResponse savedRegistration = null;
        try {
            savedRegistration = registrationService.savePreliminaryAssessment(request,applicationNo);
        } catch (DataException exception) {
            return RestControllerBase.error(exception);
        }
        return ResponseEntity.ok(savedRegistration);
    }
}
