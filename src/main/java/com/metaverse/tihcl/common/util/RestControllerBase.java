package com.metaverse.tihcl.common.util;


import com.metaverse.tihcl.exceptions.ApplicationAbstractException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public abstract class RestControllerBase {

    public  static ResponseEntity<ApplicationAPIResponse<?>> error(ApplicationAbstractException ex) {
        return new ResponseEntity<>(
                ApplicationAPIResponse.builder()
                        .message(ex.getMessage())
                        .success(false)
                        .code(ex.getErrorCode())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatusCode.valueOf(ex.getStatusCode())
        );
    }
}

