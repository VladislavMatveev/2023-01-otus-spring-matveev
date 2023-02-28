package ru.otus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig implements ReaderServiceSettingsProvider, ApplicationServiceSettingsProvider {
    private final String pathToFile;
     private final int CorrectAnswersToWinCount;
    public ApplicationConfig(@Value("${questions.path}") String pathToFile,
                             @Value("${questions.correctAnswers}") int CorrectAnswersToWinCount) {
        this.pathToFile = pathToFile;
        this.CorrectAnswersToWinCount = CorrectAnswersToWinCount;
    }

    @Override
    public String getPathToFile() {
        return pathToFile;
    }

    @Override
    public int getNumberOfCorrectAnswers() {
        return CorrectAnswersToWinCount;
    }
}
