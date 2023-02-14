package ru.otus.exceptions;

public class AppRuntimeException extends RuntimeException{
    public AppRuntimeException(Throwable cause) {
        super(cause);
    }
}
