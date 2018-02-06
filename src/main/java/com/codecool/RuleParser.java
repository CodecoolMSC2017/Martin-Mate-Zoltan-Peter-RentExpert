package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;

    private ArrayList<Element> rules;


    public RuleParser(String rulesXml) throws ParserConfigurationException, SAXException, IOException {
        loadXMLDocument(rulesXml);
        this.ruleRepository = new RuleRepository();
    }

    private void getElements() {
        NodeList nList = dom.getElementsByTagName("Rule");

        for (int i = 0; i < nList.getLength();i++) {
            Node nNode = nList.item(i);


            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nNode;
                //e.getElementsByTagName("Question");
                rules.add(e);

            }
        }
    }

    private String getQuestion(int i) {
            return rules.get(i).getElementsByTagName("Question").item(0).getTextContent();
    }


    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }
}