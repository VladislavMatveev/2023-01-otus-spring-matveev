package ru.otus.entity;

import java.util.List;

public class QuestionImpl implements Question{
    private String text;
    private List<Answer> answers;
    private List<Answer> correctAnswers;

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
