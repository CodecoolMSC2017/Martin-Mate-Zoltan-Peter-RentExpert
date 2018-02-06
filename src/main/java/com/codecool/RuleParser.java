package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;

    private List<Element> rules = new ArrayList<>();


    public RuleParser(String rulesXml) throws ParserConfigurationException, SAXException, IOException {
        loadXMLDocument(rulesXml);
        this.ruleRepository = new RuleRepository();
        getElements();
        for (Element ruleElement : rules) {
            createQuestion(ruleElement);
        }
    }

    private void getElements() {
        NodeList nList = dom.getElementsByTagName("Rule");

        for (int i = 0; i < nList.getLength();i++) {
            Node nNode = nList.item(i);


            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nNode;
                rules.add(e);
            }
        }
    }

    private Question createQuestion(Element ruleElement){
            String id = ruleElement.getAttribute("id");
            String question = ruleElement.getElementsByTagName("Question").item(0).getTextContent();
            Element answerElement = (Element)ruleElement.getElementsByTagName("Answer").item(0);
            return new Question(id, question, createAnswer(answerElement));
    }

    private Answer createAnswer(Element answerElement) {
        return null;
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }
}