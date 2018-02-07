package com.codecool;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FactParserTest {
    @Test
    void testRuleParser() throws ParserConfigurationException, SAXException, IOException {
        FactParser fp = new FactParser("Facts");
        FactRepository factRepository = fp.getFactRepository();
    }

}