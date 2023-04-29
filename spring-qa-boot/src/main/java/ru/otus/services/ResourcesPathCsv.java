package ru.otus.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.config.ApplicationSettingsProvider;
import ru.otus.config.QuestionsSettingsProvider;
import ru.otus.services.interfaces.ResourcePathProvider;

@Service
@AllArgsConstructor
public class ResourcesPathCsv implements ResourcePathProvider {

    private final QuestionsSettingsProvider questionsProperties;
    private final ApplicationSettingsProvider appProperties;

    @Override
    public String getPath() {
        return questionsProperties.getPaths().get(appProperties.getLocale().toString());
    }
}
