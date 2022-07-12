package io.github.vitalij3.JCA.exception.api;

public class AccessDeniedException extends ClashOfClansApiException {
    public AccessDeniedException() {
        super("Access denied, either because of missing/incorrect credentials or used API token does not grant access to the requested resource.");
    }

    public AccessDeniedException(String message) {
        super(message);
    }
}
