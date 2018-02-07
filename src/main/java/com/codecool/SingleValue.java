package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class SingleValue extends Value {
    private String param;
    private List<String> params = new ArrayList<>();
    private boolean selectionType;

    public SingleValue(String param, Boolean selectionType) {
        this.param = param;
        params.add(param);
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
        return param;
    }
}
