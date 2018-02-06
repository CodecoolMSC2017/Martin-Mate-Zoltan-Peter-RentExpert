package com.codecool;

import java.util.ArrayList;

public class RuleRepository {
    ArrayList<Question> questions;

    public RuleRepository() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
