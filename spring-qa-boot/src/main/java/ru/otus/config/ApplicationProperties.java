package ru.otus.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;
import java.util.Map;

@ConfigurationProperties(prefix = "application")
@Setter
public final class ApplicationProperties implements ApplicationSettingsProvider, QuestionsSettingsProvider {
    private Locale locale;
    private int correctAnswers;
    private Map<String, String> paths;

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public Map<String, String> getPaths() {
        return paths;
    }

    @Override
    public int getNumberOfCorrectAnswers() {
        return correctAnswers;
    }
}

