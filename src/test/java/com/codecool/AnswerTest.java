package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    private Answer testAnswer;
    private List<Value> testValues;
    private SingleValue testSingleValue;

    @BeforeEach
    void setUp() {
        testValues = new ArrayList<>();
        testAnswer = new Answer(testValues);
        testSingleValue = new SingleValue("yes", true);
        testAnswer.addValue(testSingleValue);
    }

    @Test
    void testAddValue() {
        assertEquals("yes", testAnswer.getValues().get(0).getInputPattern().get(0));
    }

    @Test
    void testEvaluateAnswerByInputReturnTrue() {
        assertTrue(testAnswer.evaluateAnswerByInput("yes"));
    }

    @Test
    void testEvaluateAnswerByInputReturnFalse() {
        assertFalse(testAnswer.evaluateAnswerByInput("asd"));
    }
}