package ru.otus.service;

import lombok.NoArgsConstructor;
import ru.otus.entity.Answer;
import ru.otus.entity.Question;

import java.util.List;

@NoArgsConstructor
public class PrintServiceImpl implements PrintService {

    @Override
    public String printQuestions(List<Question> questions) {
        StringBuilder builder = new StringBuilder();

        for (Question question : questions) {
            builder.append("Question:\n")
                .append("\t" + question.getText())
                .append("\n")
                .append("Answers:\n");

            for (Answer answer : question.getAnswers()) {
                builder.append("\t")
                        .append(answer.getText())
                        .append("\n");
            }
        }

        return builder.toString();
    }
}
