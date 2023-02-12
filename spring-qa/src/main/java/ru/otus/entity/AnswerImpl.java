package ru.otus.entity;

public class AnswerImpl implements Answer {
    private final String text;

    public AnswerImpl(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
