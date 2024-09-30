package com.cambio.contacao.exception;

public class MoedaNotFoundException extends RuntimeException {
    public MoedaNotFoundException(String message) {
        super(message);
    }
}