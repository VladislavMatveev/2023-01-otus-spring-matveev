package ru.otus.config;

import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.io.OutputStream;

@Configuration
public class AppIOProperties {
    private final InputStream in;
    private final OutputStream out;

    public AppIOProperties() {
        this.in = System.in;
        this.out = System.out;
    }

    public InputStream getIn() {
        return in;
    }

    public OutputStream getOut() {
        return out;
    }
}

