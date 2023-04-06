package ru.otus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "questions")
public record AppQuestionsProperties(
        String path,
        Integer correctAnswers){
}

