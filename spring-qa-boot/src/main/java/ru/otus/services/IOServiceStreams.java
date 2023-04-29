package ru.otus.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.services.interfaces.IOService;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceStreams implements IOService {
    private final Scanner in;
    private final PrintStream out;

    public IOServiceStreams(@Value("#{T(java.lang.System).in}") InputStream in,
                            @Value("#{T(java.lang.System).out}") PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
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
