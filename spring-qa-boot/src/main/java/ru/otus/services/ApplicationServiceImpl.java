package ru.otus.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.config.QuestionsSettingsProvider;
import ru.otus.entity.Answer;
import ru.otus.entity.Question;
import ru.otus.services.interfaces.*;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final QuestionRepository readerService;
    private final PrintQuestionService printService;
    private final IOService ioService;
    private final QuestionsSettingsProvider questionsSettings;
    private final AnswerService answerService;
    private final LocalizationService localizationService;

    @Override
    public void run() {
        List<Question> questions = readerService.getAll();

        int correctAnswersCount = 0;

        ioService.println(localizationService.localize("main.ask-name"));
        String studentName = ioService.readLine();

        for (Question question : questions) {
            ioService.println(printService.print(question));
            ioService.println(localizationService.localize("main.answer"));

            Answer answer = new Answer(ioService.readLine());
            if (answerService.isCorrectAnswer(question.getCorrectAnswers(), answer)) {
                correctAnswersCount++;
            }
        }
        ioService.println(localizationService.localize("main.correct", new String[]{String.valueOf(correctAnswersCount)}));

        if (correctAnswersCount >= questionsSettings.getNumberOfCorrectAnswers()) {
            ioService.println(localizationService.localize("main.test-passed", new String[]{studentName}));
        } else {
           ioService.println(localizationService.localize("main.test-failed", new String[]{studentName}));
        }
    }
}
