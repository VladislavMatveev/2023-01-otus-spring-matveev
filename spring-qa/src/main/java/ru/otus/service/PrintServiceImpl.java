package ru.otus.service;

import ru.otus.entity.Answer;
import ru.otus.entity.Question;

import java.util.List;

public class PrintServiceImpl implements PrintService{

    @Override
    public void printQuestions(List<Question> questions) {
        for (Question question: questions) {
            print("Question:");
            print("\t" + question.getText());

            print("Answers:");
            for (Answer answer: question.getAnswers()) {
                print("\t" + answer.getText());
            }
            print("");
        }
    }

    private void print(String message) {
        System.out.println(message);
    }
}
