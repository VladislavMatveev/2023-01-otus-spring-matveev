package ru.otus.service;

import lombok.AllArgsConstructor;

import java.io.PrintStream;

@AllArgsConstructor
public class IOServiceImpl implements IOService{
    PrintStream out;
    @Override
    public void println(String text) {
        out.println(text);
    }
}
