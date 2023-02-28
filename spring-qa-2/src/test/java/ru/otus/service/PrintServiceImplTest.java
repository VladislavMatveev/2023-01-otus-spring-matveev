package ru.otus.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.entity.Answer;
import ru.otus.entity.Question;
import ru.otus.service.interfaces.PrintService;

import java.util.ArrayList;
import java.util.List;

class PrintServiceImplTest {

    private final String EXPECTED_TEXT = """
            Question:
            \tWhat color is the sun?
            Answers:
            \tRed
            \tGreen
            \tWhite
            
            """;

    @Test
    @DisplayName("Test questions output")
    void printQuestions() {
        Answer answerRed = new Answer("Red");
        Answer answerGreen = new Answer("Green");
        Answer answerWhite = new Answer("White");

        List<Answer> answers = new ArrayList<>();
        answers.add(answerRed);
        answers.add(answerGreen);
        answers.add(answerWhite);

        Question question = new Question("What color is the sun?", answers, new ArrayList<>());

        PrintService printService = new PrintServiceImpl();

        Assertions.assertEquals(EXPECTED_TEXT, printService.printQuestion(question));

    }
}