package com.pathz.boot.rest.exception;

public class NoMoreItemsException extends RuntimeException {
    public NoMoreItemsException(String message) {
        super(message);
    }
}