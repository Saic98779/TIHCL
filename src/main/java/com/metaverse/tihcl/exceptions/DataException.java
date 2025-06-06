package com.metaverse.tihcl.exceptions;

import com.metaverse.tihcl.exceptions.ApplicationAbstractException;

import java.util.List;

public class DataException extends ApplicationAbstractException {

    public DataException(String message, String errorCode) {
        super(message, errorCode);
    }

    public DataException(String message, String errorCode, int statusCode) {
        super(message, errorCode, statusCode);
    }

    public DataException(String message, String errorCode, int statusCode, List<String> errors) {
        super(message, errorCode, statusCode, errors);
    }
}
