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

    @Override
    public String toString() {
        String param ="";

        for (int i = 0; i < params.size();i++) {
            if (i == params.size()-1) {
                param += params.get(i);
            } else {
                param += params.get(i) + ",";
            }
        }
        return param;

    }
}