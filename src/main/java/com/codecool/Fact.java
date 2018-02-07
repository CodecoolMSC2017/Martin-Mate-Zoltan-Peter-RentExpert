package com.codecool;

import java.util.HashMap;
import java.util.Set;

public class Fact {

    private String id;
    private String description;
    private HashMap<String, Boolean> evals;

    public Fact(String id, String description, HashMap<String, Boolean> evals) {
        this.id = id;
        this.description = description;
        this.evals = evals;
    }

    public Set<String> getIdSet() {
        return evals.keySet();
    }

    public void setFactValue(String id, boolean value) {

    }

    public boolean getValueById(String id) {
        return evals.get(id);
    }

    public String getDescription() {
        return description;
    }

}
