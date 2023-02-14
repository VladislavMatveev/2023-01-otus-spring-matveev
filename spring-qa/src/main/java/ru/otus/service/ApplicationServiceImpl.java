package ru.otus.service;

import lombok.AllArgsConstructor;
import ru.otus.entity.Question;

import java.util.List;

@AllArgsConstructor
public class ApplicationServiceImpl implements ApplocationService{

    private ReaderService readerService;
    private PrintService printService;
    private IOService ioService;
    @Override
    public void run() {
        List<Question> questions = readerService.readQuestions();

        String result = printService.printQuestions(questions);
        ioService.println(result);
    }

}
