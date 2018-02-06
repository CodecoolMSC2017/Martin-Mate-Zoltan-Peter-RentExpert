package com.codecool;

import java.util.*;

public class QuestionIterator implements Iterator<Question> {
    private List<Question> questions;
    private int idCounter = 0;

    public QuestionIterator(List<Question> questions) {
        this.questions = questions;
    }

    public boolean hasNext() {
        return idCounter < questions.size();
    }

    public Question next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            Question question = questions.get(idCounter);
            idCounter++;
            return question;
        }
    }
}
