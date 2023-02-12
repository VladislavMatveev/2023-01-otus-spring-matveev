package ru.otus.entity;

import java.util.List;

public class QuestionImpl implements Question{
    private final String text;
    private final List<Answer> answers;
    private final List<Answer> correctAnswers;

    public QuestionImpl(String text, List<Answer> answers, List<Answer> correctAnswers) {
        this.text = text;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

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
