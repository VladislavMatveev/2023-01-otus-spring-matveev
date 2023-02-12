package ru.otus.entity;

import java.util.List;

public interface Question {
    String getText();

    List<Answer> getAnswers();

    List<Answer> getCorrectAnswers();
}
