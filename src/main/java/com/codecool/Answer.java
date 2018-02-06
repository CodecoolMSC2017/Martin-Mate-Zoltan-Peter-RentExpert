package com.codecool;

import java.util.InputMismatchException;
import java.util.List;

public class Answer {

    private List<Value> values;

    public void addValue(Value value) {
        values.add(value);
    }

    public boolean evaluateAnswerByInput(String input) {
        boolean contains = false;
        try {
            for (Value value: values) {
                if (value.getInputPattern().contains(input)) {
                    contains = true;
                    break;
                }
            }
            return contains;
        } catch (InputMismatchException ime) {
            System.out.println("Text (string) please!");
        }
        return false;
    }


}
