package com.ibshort.auth.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String exception) {
        super(exception);
    }
}
