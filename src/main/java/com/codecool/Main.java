package com.codecool;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        ESProvider ep = new ESProvider(new RuleParser("Rules"),new FactParser("Facts"));
        ep.collectAnswers();
        System.out.println(ep.evaluate());
    }
}
