package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RuleParserTest {
    RuleParser ruPa;



    @BeforeEach
    void setUp() throws IOException, SAXException, ParserConfigurationException {
        ruPa = new RuleParser("RulesTest");
    }


    @Test
    void testCreateQuestion() {
        assertEquals(ruPa.getRuleRepository().getQuestions().get(0).getId(),"testID1");
        assertEquals(ruPa.getRuleRepository().getQuestions().get(0).getQuestion(),"Test question?");
        assertEquals(ruPa.getRuleRepository().getQuestions().get(1).getQuestion(),"Chickenbody?");

    }

}