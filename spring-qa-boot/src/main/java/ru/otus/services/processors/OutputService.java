package ru.otus.services.processors;

public interface OutputService {
    void printLocalized(String msg_code, String[] params);
    void printLocalized(String msg_code);
    void println(String msg);
}
