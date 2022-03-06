package com.example.insurancecompany.exception;

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

        @ExceptionHandler({ExistingEntityException.class, AssignedRoleException.class
                , WeakPasswordException.class, PdfCreateException.class})
        public ResponseEntity<Object> handleBadRequestException(Exception e, WebRequest request) {

                ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),
                        request.getDescription(false), ZonedDateTime.now());

                return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

        }

        @ExceptionHandler({UsernameNotFoundException.class, EntityNotFoundException.class})
        public ResponseEntity<Object> handleNotFoundException(Exception e, WebRequest request) {

                ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),
                        request.getDescription(false), ZonedDateTime.now());

                return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

        }

        @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
        public ResponseEntity<Object> handleMethodNotAllowedException(Exception e, WebRequest request) {

                ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),
                        request.getDescription(false), ZonedDateTime.now());

                return new ResponseEntity<>(errorDetails, HttpStatus.METHOD_NOT_ALLOWED);

        }

}
