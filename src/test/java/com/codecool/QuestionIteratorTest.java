package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionIteratorTest {
    private List<Question> testList;
    private List<Question> emptyTestList;
    private List<Value> testValues;
    private QuestionIterator qi1;
    private QuestionIterator qi2;
    private Answer testAnswer;
    private Question testQuestion;

    @BeforeEach
    void setUp() {
        testList = new ArrayList<>();
        emptyTestList = new ArrayList<>();
        testList.add(testQuestion);
        testValues = new ArrayList<>();
        qi1 = new QuestionIterator(testList);
        qi2 = new QuestionIterator(emptyTestList);
        testAnswer = new Answer(testValues);
        testQuestion = new Question("test", "test", testAnswer);
    }

    @Test
    void hasNext() {
        assertTrue(qi1.hasNext());
        assertFalse(qi2.hasNext());
    }

    @Test
    void next() {
        assertEquals(qi1.next(), testList.get(0));
    }

    @Test
    void nextThrowsEx() {
        boolean thrown = false;
        try {
            qi2.next();
        } catch (Exception ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }

}