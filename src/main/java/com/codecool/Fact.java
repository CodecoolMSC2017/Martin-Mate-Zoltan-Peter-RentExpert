package com.codecool;

import java.util.*;

public class Fact {

    private String id;
    private String description;
    private HashMap<String, Boolean> evals;

    public Fact(String id, String description, HashMap<String, Boolean> evals) {
        this.id = id;
        this.description = description;
        this.evals = evals;
    }

    public HashMap<String, Boolean> getEvals() {
        return evals;
    }

    public Set<String> getIdSet() {
        return evals.keySet();
    }

    public void setFactValue(String id, boolean value) {
        Set<String> evalsKeys = evals.keySet();
        List<String> keysList = new ArrayList<>(evalsKeys);
        Boolean evalValue = getValueById(id);
        for (int i = 0; i < keysList.size(); i++) {
            if (id.equals(keysList.get(i))) {
                evalValue = value;
            }
        }
    }

    public boolean getValueById(String id) {
        return evals.get(id);
    }

    public String getDescription() {
        return description;
    }

}
