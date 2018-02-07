package com.codecool;

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
            ruleRepository.addQuestion(createQuestion(ruleElement));
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
        List<Value> values= new ArrayList<>();
        Element selectionElement = (Element)answerElement.getElementsByTagName("Selection").item(0);
        if(selectionElement.getChildNodes().item(1).getNodeName().equals("SingleValue")) {
            Element singleValueElement = (Element) selectionElement.getElementsByTagName("SingleValue").item(0);
            SingleValue sv = new SingleValue(singleValueElement.getAttribute("value"),true);
            values.add(sv);
        }
        else if(selectionElement.getChildNodes().item(1).getNodeName().equals("MultipleValue")){
            Element multipleValueElement = (Element) selectionElement.getElementsByTagName("MultipleValue").item(0);
            List<String> multiValue =new ArrayList<>();
            multiValue.add(multipleValueElement.getAttribute("value"));
            MultipleValue mv = new MultipleValue(multiValue,true);
            values.add(mv);
        }
        Answer ans = new Answer(values);
        return ans;
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }
}