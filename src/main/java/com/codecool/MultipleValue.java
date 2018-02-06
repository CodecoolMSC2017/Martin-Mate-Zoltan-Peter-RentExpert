package com.codecool;

import java.util.List;

public class MultipleValue extends Value {
    private List<String> params;

    public MultipleValue(List<String> params) {
        this.params = params;
    }

    public List<String> getInputPattern() {
        return params;
    }
}