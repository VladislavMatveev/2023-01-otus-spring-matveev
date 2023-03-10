package ru.otus.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
public class Question {

    private final String text;
    private final List<Answer> answers;
    private final List<Answer> correctAnswers;

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Answer> getCorrectAnswers() {
        return correctAnswers;
    }
}
