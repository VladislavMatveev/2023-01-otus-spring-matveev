package ru.otus.config;

import java.util.Locale;
import java.util.Map;

public interface QuestionsSettingsProvider {
    Map<String, String> getPaths();
    int getNumberOfCorrectAnswers();
}
