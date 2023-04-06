package ru.otus.services.interfaces;

import ru.otus.entity.Question;

import java.util.List;

public interface ReaderService {
    List<Question> readQuestions();
}
