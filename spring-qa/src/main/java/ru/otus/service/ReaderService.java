package ru.otus.service;

import ru.otus.entity.Question;

import java.util.List;

public interface ReaderService {
    List<Question> readQuestions();
}
