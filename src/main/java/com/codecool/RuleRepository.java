package com.codecool;

import java.util.ArrayList;

public class RuleRepository {
    private ArrayList<Question> questions;

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public RuleRepository() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
