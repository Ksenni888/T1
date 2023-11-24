package org.example.exeption;

public class NoInformationFoundException extends RuntimeException {
    public NoInformationFoundException(String message) {
        super(message);
    }
}