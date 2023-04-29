package ru.otus.services;

import org.springframework.stereotype.Service;
import ru.otus.entity.Answer;

import java.util.List;

@Service
public class AnswerService {
    public boolean isCorrectAnswer(List<Answer> correctAnswersList, Answer answer) {
        for (Answer correctAnswer: correctAnswersList) {
            if (correctAnswer.getText().equalsIgnoreCase(answer.getText())) {
                return true;
            }
        }
        return false;
    }
}
