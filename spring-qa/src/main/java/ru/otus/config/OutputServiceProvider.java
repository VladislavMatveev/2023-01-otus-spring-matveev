package ru.otus.config;

import java.io.PrintStream;

public interface OutputServiceProvider {
    PrintStream getOutputStream();
}
