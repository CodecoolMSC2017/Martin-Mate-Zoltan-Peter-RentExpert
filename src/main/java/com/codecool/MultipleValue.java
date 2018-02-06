package com.codecool;

import java.util.List;

public class MultipleValue extends Value {
    private List<String> params;
    private boolean selectionType;

    public MultipleValue(List<String> params, Boolean selectionType) {
        this.params = params;
        this.selectionType = selectionType;
    }

    public List<String> getInputPattern() {
        return params;
    }

    public boolean getSelectionType() {
        return selectionType;
    }
}