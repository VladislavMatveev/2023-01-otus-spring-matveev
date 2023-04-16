package ru.otus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "questions")
public record AppQuestionsProperties(
        Map<String, String> paths,
        Integer correctAnswers){
}

