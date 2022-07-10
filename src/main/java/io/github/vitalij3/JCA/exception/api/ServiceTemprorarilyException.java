package io.github.vitalij3.JCA.exception.api;

public class ServiceTemprorarilyException extends Exception {
    public ServiceTemprorarilyException() {
        super("Service is temprorarily unavailable because of maintenance.");
    }
}
