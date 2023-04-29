package ru.otus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.services.ApplicationServiceImpl;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(Main.class, args);
        var app = ctx.getBean(ApplicationServiceImpl.class);
        app.run();
    }
}