package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;

    public RuleParser(String rulesXml) throws ParserConfigurationException, SAXException, IOException {
        loadXMLDocument(rulesXml);
        this.ruleRepository = new RuleRepository();
        for (Element e : getElements()) {
           // this.ruleRepository.addQuestion(toQuestion(e));
        }
    }

    private Element[] getElements() {
        dom.getElementsByTagName("Rule");
        return new Element[0];
    }

    private Question toQuestion(Element e) {
        return null;
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }
}