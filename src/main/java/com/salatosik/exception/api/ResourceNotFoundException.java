package com.salatosik.exception.api;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException() {
        super("Resource was not found");
    }
}
