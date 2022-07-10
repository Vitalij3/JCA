package io.github.vitalij3.JCA.exception.api;

public class AccessDeniedException extends Exception {
    public AccessDeniedException() {
        super("\t\n" +
                "Access denied, either because of missing/incorrect credentials or used API token does not grant access to the requested resource.");
    }
}
