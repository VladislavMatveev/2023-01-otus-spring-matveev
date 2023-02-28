package ru.otus.service.interfaces;

import ru.otus.entity.Answer;
import ru.otus.service.processors.InputService;
import ru.otus.service.processors.OutputService;

public interface IOService extends InputService, OutputService {
    Answer readAnswer();
}
