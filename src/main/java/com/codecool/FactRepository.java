package com.codecool;

import java.util.ArrayList;

public class FactRepository {
    private ArrayList<Question> facts;

    public ArrayList<Question> getFacts() {
        return facts;
    }

    public FactRepository() {
        facts = new ArrayList<>();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }
}
