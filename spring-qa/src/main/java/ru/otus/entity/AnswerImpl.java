package ru.otus.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
public class AnswerImpl implements Answer {

    @Getter
    private final String text;
}
