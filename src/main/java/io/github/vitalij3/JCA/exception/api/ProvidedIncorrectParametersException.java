package io.github.vitalij3.JCA.exception.api;

public class ProvidedIncorrectParametersException extends Exception {
    public ProvidedIncorrectParametersException() {
        super("Client provided incorrect parameters for the request.");
    }

    public ProvidedIncorrectParametersException(String message) {
        super(message);
    }

    public String message;
}
