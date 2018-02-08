package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class FactIteratorTest {
    private List<Fact> testList;
    private List<Fact> emptyTestList;
    private HashMap<String, Boolean> testMap;
    private FactIterator fi1;
    private FactIterator fi2;

    @BeforeEach
    void setUp() {
        testList = new ArrayList<>();
        emptyTestList = new ArrayList<>();
        testMap = new HashMap<>();
        Fact fact1 = new Fact("test", "testtest", testMap);
        testList.add(fact1);
        fi1 = new FactIterator(testList);
        fi2 = new FactIterator(emptyTestList);


    }

    @Test
    void hasNext() {
        assertTrue(fi1.hasNext());
        assertFalse(fi2.hasNext());
    }

    @Test
    void next() {
        assertEquals(fi1.next(), testList.get(0));
    }

    @Test
    void nextThrowsEx() {
        boolean thrown = false;
        try {
            fi2.next();
        } catch (Exception ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}