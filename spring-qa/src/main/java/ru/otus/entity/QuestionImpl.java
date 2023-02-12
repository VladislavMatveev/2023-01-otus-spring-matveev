package ru.otus.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
public class QuestionImpl implements Question{

    private final String text;
    private final List<Answer> answers;
    private final List<Answer> correctAnswers;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public List<Answer> getCorrectAnswers() {
        return correctAnswers;
    }
}
