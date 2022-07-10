package com.github.salatosik.JCA.exception.api;

public class RequestThrottledException extends Exception {
    public RequestThrottledException() {
        super("Request was throttled, because amount of requests was above the threshold defined for the used API token.");
    }
}
