package io.github.vitalij3.JCA.exception.api;

public class ResourceNotFoundException extends ClashOfClansApiException {
    public ResourceNotFoundException() {
        super("Resource was not found");
    }
}
