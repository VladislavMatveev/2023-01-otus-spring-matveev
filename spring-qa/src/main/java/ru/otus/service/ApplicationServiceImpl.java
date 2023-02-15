package ru.otus.service;

import lombok.AllArgsConstructor;
import ru.otus.entity.Question;
import ru.otus.service.interfaces.ApplicationService;
import ru.otus.service.interfaces.IOService;
import ru.otus.service.interfaces.PrintService;
import ru.otus.service.interfaces.ReaderService;

import java.util.List;

@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

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
