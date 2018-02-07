package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;

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

    public Iterator<Question> getIterator() {
        Iterator questionIterator = new QuestionIterator(questions);
        return questionIterator;
    }
}
