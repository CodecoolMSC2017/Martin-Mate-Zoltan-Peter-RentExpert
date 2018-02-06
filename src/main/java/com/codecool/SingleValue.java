package com.codecool;

import java.util.List;

public class SingleValue extends Value {
    private String param;
    private List<String> params;

    public SingleValue(String param) {
        this.param = param;
        params.add(param);
    }

    public List<String> getInputPattern() {
        return params;
    }
}
