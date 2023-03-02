package ru.otus.exceptions;

public class IncorrectDataInLineException extends RuntimeException{
    public IncorrectDataInLineException(String message) {
        super(message);
    }
}
