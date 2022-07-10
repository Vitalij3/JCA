package com.github.salatosik.JCA.exception.api;

public class UnknownErrorHappenedException extends Exception {
    public UnknownErrorHappenedException() {
        super("Unknown error happened when handling the request.");
    }
}
