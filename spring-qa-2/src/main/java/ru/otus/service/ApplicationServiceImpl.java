package ru.otus.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.config.ApplicationServiceSettingsProvider;
import ru.otus.entity.Answer;
import ru.otus.entity.Question;
import ru.otus.service.interfaces.ApplicationService;
import ru.otus.service.interfaces.IOService;
import ru.otus.service.interfaces.PrintService;
import ru.otus.service.interfaces.ReaderService;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ReaderService readerService;
    private final PrintService printService;
    private final IOService ioService;
    private final ApplicationServiceSettingsProvider applicationServiceProvider;

    @Override
    public void run() {
        List<Question> questions = readerService.readQuestions();

        int correctAnswersCount = 0;

        ioService.println("Enter your name:");
        String studentName = ioService.readLine();

        for (Question question : questions) {
            ioService.println(printService.printQuestion(question));
            ioService.println("Your answer:");

            Answer answer = new Answer(ioService.readLine());
            if (question.getCorrectAnswers().contains(answer)) {
                correctAnswersCount++;
            }
        }
        ioService.println("Correct: " + correctAnswersCount);

        ioService.println(studentName +
                (correctAnswersCount >= applicationServiceProvider.getNumberOfCorrectAnswers() ? " passed " : "  failed ")
                + "the test");

    }

}
