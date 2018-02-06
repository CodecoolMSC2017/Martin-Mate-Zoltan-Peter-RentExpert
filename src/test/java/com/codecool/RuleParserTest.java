package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class RuleParserTest {

    @Test
    void testRuleParser() throws ParserConfigurationException, SAXException, IOException {
        RuleParser rp = new RuleParser("Rules");
        RuleRepository ruleRepository = rp.getRuleRepository();

        int actualCount = 0;
        Iterator<Question> iterator = ruleRepository.getIterator();
        while (iterator.hasNext()) {
            Question question = iterator.next();
            assertEquals(question.getId(), "asd");
            actualCount++;
        }
        assertEquals(0, actualCount);
    }
}