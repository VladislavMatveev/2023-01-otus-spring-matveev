package ru.otus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.InputStream;
import java.io.PrintStream;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig implements ReaderServiceSettingsProvider, InputServiceProvider, OutputServiceProvider, ApplicationServiceSettingsProvider {
    private final String pathToFile;
    private final PrintStream outputStream;
    private final InputStream inputStream;
    private final int CorrectAnswersToWinCount;
    public ApplicationConfig(@Value("${questions.path}") String pathToFile,
                             @Value("${io.out}") PrintStream outputStream,
                             @Value("${io.in}")InputStream inputStream,
                             @Value("${questions.correctAnswers}") int CorrectAnswersToWinCount) {
        this.pathToFile = pathToFile;
        this.outputStream = outputStream;
        this.inputStream = inputStream;
        this.CorrectAnswersToWinCount = CorrectAnswersToWinCount;
    }

    @Override
    public String getPathToFile() {
        return pathToFile;
    }

    @Override
    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public PrintStream getOutputStream() {
        return outputStream;
    }

    @Override
    public int getNumberOfCorrectAnswers() {
        return CorrectAnswersToWinCount;
    }
}
