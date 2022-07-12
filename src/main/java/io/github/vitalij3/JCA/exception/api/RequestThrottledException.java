package io.github.vitalij3.JCA.exception.api;

public class RequestThrottledException extends ClashOfClansApiException {
    public RequestThrottledException() {
        super("Request was throttled, because amount of requests was above the threshold defined for the used API token.");
    }
}
