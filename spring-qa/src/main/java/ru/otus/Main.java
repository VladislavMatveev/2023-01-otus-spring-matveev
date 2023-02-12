package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.entity.Question;
import ru.otus.service.PrintService;
import ru.otus.service.ReaderService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        ReaderService readerService = context.getBean(ReaderService.class);

        List<Question> questions = readerService.readQuestions();

        PrintService printService = context.getBean(PrintService.class);
        String result = printService.printQuestions(questions);
        System.out.println(result);
    }
}