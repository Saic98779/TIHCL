package com.metaverse.tihcl.registration.controller;

import com.metaverse.tihcl.common.response.TihclResponse;
import com.metaverse.tihcl.common.util.RestControllerBase;
import com.metaverse.tihcl.exceptions.DataException;
import com.metaverse.tihcl.registration.service.RegistrationRequest;
import com.metaverse.tihcl.registration.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

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
}
