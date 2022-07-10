package io.github.vitalij3.JCA.exception.api;

public class UnknownErrorHappenedException extends Exception {
    public UnknownErrorHappenedException() {
        super("Unknown error happened when handling the request.");
    }
}
