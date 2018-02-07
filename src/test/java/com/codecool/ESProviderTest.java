package com.codecool;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ESProviderTest {
    @Test
    public void collectAnswersTest()throws ParserConfigurationException, SAXException, IOException {
        RuleParser rp = new RuleParser("Rules");
        FactParser fp = new FactParser("Facts");
        ESProvider esp = new ESProvider(rp,fp);
        esp.collectAnswers();
    }
}