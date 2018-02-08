package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RuleRepositoryTest {

    @Test
    void testRuleRepository() throws ParserConfigurationException, SAXException, IOException {
        RuleRepository ruleRep = new RuleRepository();
        List<Value> testValues = new ArrayList<Value>();
        SingleValue testValue = new SingleValue("test", true);
        testValues.add(testValue);
        Question q = new Question("1","testQuestion", new Answer(testValues));
        ruleRep.addQuestion(q);
        assertEquals(ruleRep.getQuestions().get(0).getId(), q.getId());
    }
}