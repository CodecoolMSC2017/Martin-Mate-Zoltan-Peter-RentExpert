package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FactParserTest {
    FactParser faP;

    @BeforeEach
    void setUp() throws IOException, SAXException, ParserConfigurationException {
        faP = new FactParser("FactsTest");
    }

    @Test
    void testCreateFact() {
        assertEquals(faP.getFactRepository().getFacts().get(0).getDescription(), "TestDistrict 1");
        assertEquals(faP.getFactRepository().getFacts().get(1).getEvals().get("chicken"), true);
        assertEquals(faP.getFactRepository().getFacts().get(1).getDescription(), "TestDistrict 2");
    }

}