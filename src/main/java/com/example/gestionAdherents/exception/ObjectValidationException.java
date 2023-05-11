package com.example.gestionAdherents.exception;

import lombok.Getter;

import java.util.Set;

public class ObjectValidationException  extends RuntimeException{
    @Getter
    private final Set<String> validations;
    @Getter
    private final String validationSource;

    public ObjectValidationException(Set<String> validations, String validationSource) {
        this.validations = validations;
        this.validationSource = validationSource;
    }
}
