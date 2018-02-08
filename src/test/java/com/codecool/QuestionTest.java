package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    private Question testQuestionToSingleValue;
    private Answer testAnswerSingleValue;
    private List<Value> testValuesSingleValue;

    private Question testQuestionToMultipleValue;
    private Answer testAnswerMultipleeValue;
    private List<Value> testValuesMultipleValue;

    @BeforeEach
    void setUp() {
        testValuesSingleValue = new ArrayList<>();
        testValuesSingleValue.add(new SingleValue("yes", true));
        testValuesSingleValue.add(new SingleValue("no", false));
        testAnswerSingleValue = new Answer(testValuesSingleValue);
        testQuestionToSingleValue = new Question("traffic", "Do you have a car?", testAnswerSingleValue);

        testValuesMultipleValue = new ArrayList<>();
        testValuesMultipleValue.add(
                new MultipleValue(new ArrayList<>(Arrays.asList("playground", "hospital", "kindergarten", "school" ,"supermarket")),
                true));
        testValuesMultipleValue.add(
                new MultipleValue(new ArrayList<>(Arrays.asList("bar", "brothel", "grocery", "fast food")),
                false));
        testAnswerMultipleeValue = new Answer(testValuesMultipleValue);
        testQuestionToMultipleValue = new Question("family", "What opportunity is the most important?", testAnswerMultipleeValue);
    }

    @Test
    void testGetEvalutedAnswerToSingleValueContain() {
        assertTrue(testQuestionToSingleValue.getEvalutedAnswer("yes"));
        assertFalse(testQuestionToSingleValue.getEvalutedAnswer("no"));
    }

    @Test
    void testGetEvalutedAnswerToSingleValueNotContain() {
        assertFalse(testQuestionToSingleValue.getEvalutedAnswer("yesno"));
    }

    @Test
    void testGetEvalutedAnswerToMultipleValueContain() {
        assertTrue(testQuestionToMultipleValue.getEvalutedAnswer("hospital"));
        assertFalse(testQuestionToMultipleValue.getEvalutedAnswer("bar"));
    }

    @Test
    void testGetEvalutedAnswerToMultipleValueNotContain() {
        assertFalse(testQuestionToMultipleValue.getEvalutedAnswer("baar"));
    }
}