package ru.otus.services;

import org.springframework.stereotype.Service;
import ru.otus.config.AppIOProperties;
import ru.otus.services.interfaces.IOService;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceStreams implements IOService {
    private final Scanner input;
    private final PrintStream output;
    public IOServiceStreams(AppIOProperties applicationProperties) {
        this.input = new Scanner(applicationProperties.getIn());
        this.output = (PrintStream) applicationProperties.getOut();
    }

    @Override
    public void println(String text) {
        output.println(text);
    }

    @Override
    public String readLine() {
        return input.nextLine();
    }

}
