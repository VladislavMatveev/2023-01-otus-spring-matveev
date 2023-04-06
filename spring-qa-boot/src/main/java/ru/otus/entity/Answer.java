package ru.otus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
public class Answer {

    @Getter
    private final String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return text.equalsIgnoreCase(answer.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
