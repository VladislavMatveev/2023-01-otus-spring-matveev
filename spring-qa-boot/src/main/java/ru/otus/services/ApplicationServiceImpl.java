package ru.otus.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.config.QuestionsSettingsProvider;
import ru.otus.entity.Answer;
import ru.otus.entity.Question;
import ru.otus.services.interfaces.ApplicationService;
import ru.otus.services.interfaces.IOService;
import ru.otus.services.interfaces.PrintQuestionService;
import ru.otus.services.interfaces.QuestionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final QuestionRepository readerService;
    private final PrintQuestionService printService;
    private final IOService ioService;
    private final QuestionsSettingsProvider questionsSettings;

    @Override
    public void run() {
        List<Question> questions = readerService.getAll();

        int correctAnswersCount = 0;

        ioService.printLocalized("main.ask-name");
        String studentName = ioService.readLine();

        for (Question question : questions) {
            ioService.println(printService.print(question));
            ioService.printLocalized("main.answer");

            Answer answer = new Answer(ioService.readLine());
            if (question.getCorrectAnswers().contains(answer)) {
                correctAnswersCount++;
            }
        }
        ioService.printLocalized("main.correct", new String[]{String.valueOf(correctAnswersCount)});

        if (correctAnswersCount >= questionsSettings.getNumberOfCorrectAnswers()) {
            ioService.printLocalized("main.test-passed", new String[]{studentName});
        } else {
           ioService.printLocalized("main.test-failed", new String[]{studentName});
        }
    }
}
