package ru.otus.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.services.interfaces.IOService;
import ru.otus.services.interfaces.LocalizationService;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceStreams implements IOService {
    private final Scanner in;
    private final PrintStream out;
    private final LocalizationService localizationService;

    public IOServiceStreams(@Value("#{T(java.lang.System).in}") InputStream in,
                            @Value("#{T(java.lang.System).out}") PrintStream out,
                            LocalizationService localizationService) {
        this.in = new Scanner(in);
        this.out = out;
        this.localizationService = localizationService;
    }

    @Override
    public void printLocalized(String msg_code, String[] params) {
        out.println(localizationService.localize(msg_code, params));
    }

    @Override
    public void printLocalized(String msg_code) {
        printLocalized(msg_code, null);
    }

    @Override
    public void println(String msg) {
        out.println(msg);
    }

    @Override
    public String readLine() {
        return in.nextLine();
    }

}
