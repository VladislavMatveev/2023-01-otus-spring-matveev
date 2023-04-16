package ru.otus.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.config.AppQuestionsProperties;
import ru.otus.entity.Answer;
import ru.otus.entity.Question;
import ru.otus.services.interfaces.ApplicationService;
import ru.otus.services.interfaces.IOService;
import ru.otus.services.interfaces.PrintService;
import ru.otus.services.interfaces.ReaderService;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ReaderService readerService;
    private final PrintService printService;
    private final IOService ioService;
    private final AppQuestionsProperties applicationProperties;

    @Override
    public void run() {
        List<Question> questions = readerService.readQuestions();

        int correctAnswersCount = 0;

        ioService.printLocalized("main.ask-name");
        String studentName = ioService.readLine();

        for (Question question : questions) {
            ioService.println(printService.printQuestion(question));
            ioService.printLocalized("main.answer");

            Answer answer = new Answer(ioService.readLine());
            if (question.getCorrectAnswers().contains(answer)) {
                correctAnswersCount++;
            }
        }
        ioService.printLocalized("main.correct", new String[]{String.valueOf(correctAnswersCount)});

        if (correctAnswersCount >= applicationProperties.correctAnswers()) {
            ioService.printLocalized("main.test-passed", new String[]{studentName});
        } else {
           ioService.printLocalized("main.test-failed", new String[]{studentName});
        }
    }
}
