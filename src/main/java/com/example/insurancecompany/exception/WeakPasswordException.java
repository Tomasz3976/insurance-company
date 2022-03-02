package com.example.insurancecompany.exception;

public class WeakPasswordException extends RuntimeException{

        public WeakPasswordException(String message) {
                super(message);
        }
}
