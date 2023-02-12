package ru.otus.service;

import ru.otus.entity.Question;

import java.util.List;

public interface PrintService {
    void printQuestions(List<Question> questions);
}
