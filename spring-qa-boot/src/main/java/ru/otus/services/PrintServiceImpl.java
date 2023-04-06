package ru.otus.services;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.entity.Question;
import ru.otus.services.interfaces.PrintService;

@NoArgsConstructor
@Service
public class PrintServiceImpl implements PrintService {

    @Override
    public String printQuestion(Question question) {

        StringBuilder builder = new StringBuilder();

        builder.append("Question:\n")
                .append("\t" + question.getText())
                .append("\n")
                .append("Answers:\n");

        question.getAnswers()
                .forEach(answer -> builder.append("\t")
                        .append(answer.getText())
                        .append("\n"));
        builder.append("\n");

        return builder.toString();
    }
}
