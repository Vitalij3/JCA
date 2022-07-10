package io.github.vitalij3.JCA.exception.api;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException() {
        super("Resource was not found");
    }
}
