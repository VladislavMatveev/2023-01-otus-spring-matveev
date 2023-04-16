package ru.otus.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.entity.Question;
import ru.otus.services.interfaces.LocalizationService;
import ru.otus.services.interfaces.PrintService;

@AllArgsConstructor
@Service
public class PrintServiceImpl implements PrintService {

    private final LocalizationService localizationService;

    @Override
    public String printQuestion(Question question) {

        StringBuilder builder = new StringBuilder();

        builder.append(localizationService.localize("print.question"))
                .append("\n")
                .append("\t" + question.getText())
                .append("\n")
                .append(localizationService.localize("print.answer"))
                .append("\n");

        question.getAnswers()
                .forEach(answer -> builder.append("\t")
                        .append(answer.getText())
                        .append("\n"));

        return builder.toString();
    }
}
