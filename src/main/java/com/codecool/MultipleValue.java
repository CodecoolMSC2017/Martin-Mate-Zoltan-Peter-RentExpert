package com.codecool;

public class MultipleValue extends Value {
    private List<string> params;

    public MultipleValue(List<string> params) {
        this.params = params;
    }

    public List<String> getInputPattern() {
        return params;
}