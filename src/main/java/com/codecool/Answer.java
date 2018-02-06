package com.codecool;

import java.util.InputMismatchException;
import java.util.List;

public class Answer {

    private List<Value> values;

    public void addValue(Value value) {
        values.add(value);
    }

    public Answer(List<Value> values) {
        this.values = values;
    }

    public List<Value> getValues() {
        return values;
    }

    public boolean evaluateAnswerByInput(String input) {
        for (Value value: values) {
            if (value.getInputPattern().contains(input)) {
                return true;
            }
        }
        return false;
    }
}
