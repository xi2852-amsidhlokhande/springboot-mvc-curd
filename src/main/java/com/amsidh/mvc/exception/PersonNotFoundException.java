package com.amsidh.mvc.exception;

public class PersonNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 4318402102896894465L;

    public PersonNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
