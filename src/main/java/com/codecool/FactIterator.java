package com.codecool;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FactIterator implements Iterator<Fact> {

    private List<Fact> facts;
    private int index = 0;

    public FactIterator(List<Fact> facts) {
        this.facts = facts;
    }

    @Override
    public boolean hasNext() {
        return index < facts.size();
    }

    @Override
    public Fact next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Fact actualFact = facts.get(index);
        index++;
        return actualFact;
    }
}
