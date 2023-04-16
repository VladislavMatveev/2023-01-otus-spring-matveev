package ru.otus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties(prefix = "application")
public record AppProperties(
        Locale locale) {
}

