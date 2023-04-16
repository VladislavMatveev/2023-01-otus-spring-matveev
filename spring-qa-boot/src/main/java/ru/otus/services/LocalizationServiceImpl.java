package ru.otus.services;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.config.AppProperties;
import ru.otus.services.interfaces.LocalizationService;

@Service
@AllArgsConstructor
public class LocalizationServiceImpl implements LocalizationService {
    private final MessageSource messageSource;
    private final AppProperties appProperties;

    @Override
    public String localize(String msg_code, String[] params) {
        return messageSource.getMessage(msg_code, params, appProperties.locale());
    }

    @Override
    public String localize(String msg_code) {
        return localize(msg_code, null);
    }
}
