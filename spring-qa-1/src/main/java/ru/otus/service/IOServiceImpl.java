package ru.otus.service;

import lombok.AllArgsConstructor;
import ru.otus.service.interfaces.IOService;

import java.io.PrintStream;

@AllArgsConstructor
public class IOServiceImpl implements IOService {
    PrintStream out;
    @Override
    public void println(String text) {
        out.println(text);
    }
}
