package ru.otus.services;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.otus.config.ApplicationSettingsProvider;
import ru.otus.config.QuestionsSettingsProvider;
import ru.otus.entity.Answer;
import ru.otus.entity.Question;
import ru.otus.exceptions.IOFromFileException;
import ru.otus.exceptions.IncorrectDataInLineException;
import ru.otus.services.interfaces.QuestionRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReaderServiceCsv implements QuestionRepository {

    private final QuestionsSettingsProvider questionsProperties;
    private final ApplicationSettingsProvider appProperties;

    private List<Question> readQuestionsFromFile() throws IOException {

        ClassPathResource resource = new ClassPathResource(questionsProperties.getPaths().get(appProperties.getLocale().toString()));
        String line;
        List<Question> questionList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {

            while ((line = reader.readLine()) != null) {
                List<Answer> answers = new ArrayList<>();
                List<Answer> correctAnswers = new ArrayList<>();

                String[] questionData = line.split(";");
                // 0 - question
                // 1 - answers
                // 2 - correct answer/answers

                if (questionData.length < 3) {
                    throw new IncorrectDataInLineException("Incorrect data in line: " + line);
                }

                for (String answerString : questionData[1].split(",")) {
                    Answer answer = new Answer(answerString);
                    answers.add(answer);
                }
                for (String answerString : questionData[2].split(",")) {
                    Answer answer = new Answer(answerString);
                    correctAnswers.add(answer);
                }
                Question question = new Question(
                        questionData[0],
                        answers,
                        correctAnswers
                );
                questionList.add(question);
            }
        }
        return questionList;
    }

    @Override
    public List<Question> getAll() {
        try {
            return readQuestionsFromFile();
        } catch (IOException e) {
            throw new IOFromFileException(e);
        }
    }
}
