package com.example.gestionAdherents.validation;

import com.example.gestionAdherents.exception.ObjectValidationException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator<T> {
    private final ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
    private final Validator validator= factory.getValidator();
    public void validate(T objectToValidation){
        Set<ConstraintViolation<T>> validations= validator.validate(objectToValidation);
        if (!validations.isEmpty()){
            Set<String> errorMessages= validations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
            throw new ObjectValidationException(errorMessages, objectToValidation.getClass().getName());
        }
    }
}
