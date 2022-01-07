package com.example1.insurancecompany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(ExistingEntityException.class)
        public ResponseEntity<Object> handleExistingEntityException(ExistingEntityException e, WebRequest request) {

                ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),
                        request.getDescription(false), ZonedDateTime.now());

                return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

        }

        @ExceptionHandler(AssignedRoleException.class)
        public ResponseEntity<Object> handleAssignedRoleException(AssignedRoleException e, WebRequest request) {

                ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),
                        request.getDescription(false), ZonedDateTime.now());

                return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

        }

        @ExceptionHandler(UsernameNotFoundException.class)
        public ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException e, WebRequest request) {

                ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),
                        request.getDescription(false), ZonedDateTime.now());

                return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

        }

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e, WebRequest request) {

                ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),
                        request.getDescription(false), ZonedDateTime.now());

                return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

        }

}
