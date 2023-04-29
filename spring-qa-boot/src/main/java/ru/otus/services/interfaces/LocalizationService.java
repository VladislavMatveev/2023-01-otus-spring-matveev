package ru.otus.services.interfaces;

public interface LocalizationService {
    String localize(String msg_code, String[] params);
    String localize(String msg_code);
}
