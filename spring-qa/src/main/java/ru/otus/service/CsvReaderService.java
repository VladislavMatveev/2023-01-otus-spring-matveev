package ru.otus.service;

import org.springframework.core.io.ClassPathResource;
import ru.otus.entity.Answer;
import ru.otus.entity.AnswerImpl;
import ru.otus.entity.Question;
import ru.otus.entity.QuestionImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderService implements ReaderService {

    private String pathToFile;

    public CsvReaderService(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    private List<Question> readQuestionsFromFile() throws IOException {
        ClassPathResource resource = new ClassPathResource(pathToFile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        String line;
        List<Question> questionList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            List<Answer> answers = new ArrayList<>();
            List<Answer> correctAnswers = new ArrayList<>();

            String[] questionData = line.split(";");
            // 0 - question
            // 1 - answers
            // 2 - correct answer/answers

            if (questionData.length < 3) {
                System.out.print("Incorrect data in line: ");
                System.out.println(line);
                continue;
            }

            for (String answerString : questionData[1].split(",")) {
                Answer answer = new AnswerImpl(answerString);
                answers.add(answer);
            }
            for (String answerString : questionData[2].split(",")) {
                Answer answer = new AnswerImpl(answerString);
                correctAnswers.add(answer);
            }
            Question question = new QuestionImpl(
                    questionData[0],
                    answers,
                    correctAnswers
            );

            questionList.add(question);
        }

        reader.close();

        return questionList;
    }

    @Override
    public List<Question> readQuestions() {
        try {
            return readQuestionsFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
