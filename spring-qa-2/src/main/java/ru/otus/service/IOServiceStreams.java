package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.config.InputServiceProvider;
import ru.otus.config.OutputServiceProvider;
import ru.otus.entity.Answer;
import ru.otus.service.interfaces.IOService;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceStreams implements IOService {
    private final Scanner input;
    private final PrintStream output;

    public IOServiceStreams(InputServiceProvider input, OutputServiceProvider output) {
        this.input = new Scanner(input.getInputStream());
        this.output = output.getOutputStream();
    }

    @Override
    public void println(String text) {
        output.println(text);
    }

    @Override
    public String readLine() {
        return input.nextLine();
    }

    @Override
    public Answer readAnswer() {
        return new Answer(readLine());
    }
}
