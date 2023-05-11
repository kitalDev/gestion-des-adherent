package com.example.gestionAdherents.handlers;

import com.example.gestionAdherents.exception.ObjectValidationException;
import com.example.gestionAdherents.exception.OperationNonPermittedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandlers {
    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ExceptionRepresentation> handlerException(ObjectValidationException objectValidationException){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("Object Not valid exception has occured")
                .errorSource(objectValidationException.getValidationSource())
                .validatorsErros(objectValidationException.getValidations())
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(representation);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> handlersException(EntityNotFoundException entityNotFoundException){
        ExceptionRepresentation exceptionRepresentation = ExceptionRepresentation.builder()
                .errorMessage(entityNotFoundException.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionRepresentation);
    }

    @ExceptionHandler(OperationNonPermittedException.class)
    public ResponseEntity<ExceptionRepresentation> handlersException(OperationNonPermittedException permittedException){
        ExceptionRepresentation exceptionRepresentation = ExceptionRepresentation.builder()
                .errorMessage(permittedException.getErrorMsg())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(exceptionRepresentation);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionRepresentation> handlersException(){
        ExceptionRepresentation exceptionRepresentation = ExceptionRepresentation.builder()
                .errorMessage("Utilisateur existe deja avec le meme email")
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionRepresentation);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionRepresentation> handlersBadCredentialsException(){
        ExceptionRepresentation exceptionRepresentation = ExceptionRepresentation.builder()
                .errorMessage("Votre email ou votre mot de passe est incorrecte")
                .build();
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(exceptionRepresentation);
    }
}
