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

    public void getElements() {
        NodeList nList = dom.getElementsByTagName("Rule");

        for (int i = 0; i < nList.getLength();i++) {
            Node nNode = nList.item(i);


            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nNode;
                rules.add(e);
            }
        }
    }

    public Question createQuestion(Element ruleElement){
            String id = ruleElement.getAttribute("id");
            String question = ruleElement.getElementsByTagName("Question").item(0).getTextContent();
            Element answerElement = (Element)ruleElement.getElementsByTagName("Answer").item(0);
            return new Question(id, question, createAnswer(answerElement));
    }

    public Answer createAnswer(Element answerElement) {
        List<Value> values= new ArrayList<>();
        Element selectionElement = (Element)answerElement.getElementsByTagName("Selection").item(0);
        if(selectionElement.getChildNodes().item(1).getNodeName().equals("SingleValue")) {
            Element singleValueElement = (Element) selectionElement.getElementsByTagName("SingleValue").item(0);
            SingleValue sv = new SingleValue(singleValueElement.getAttribute("value"),true);

            Element selectionElement2 = (Element)answerElement.getElementsByTagName("Selection").item(1);

            Element singleValueElement2 = (Element) selectionElement2.getElementsByTagName("SingleValue").item(0);
            SingleValue sv2 = new SingleValue(singleValueElement2.getAttribute("value"),false);

            values.add(sv);
            values.add(sv2);
        }
        else if(selectionElement.getChildNodes().item(1).getNodeName().equals("MultipleValue")){
            Element multipleValueElement = (Element) selectionElement.getElementsByTagName("MultipleValue").item(0);
            String[] multiVal1= multipleValueElement.getAttribute("value").split(",");
            List<String> multiValue1 =new ArrayList<>();
            for (String value:multiVal1) {
                multiValue1.add(value);
            }

            Element selectionElement2 = (Element)answerElement.getElementsByTagName("Selection").item(1);
            Element multipleValueElement2 =(Element) selectionElement2.getElementsByTagName("MultipleValue").item(0);
            String[] multiVal2 =multipleValueElement2.getAttribute("value").split(",");
            List<String> multiValue2 =new ArrayList<>();
            for (String value:multiVal2) {
                multiValue2.add(value);
            }

            MultipleValue mv1 = new MultipleValue(multiValue1,true);
            MultipleValue mv2 = new MultipleValue(multiValue2,false);

            values.add(mv1);
            values.add(mv2);
        }
        Answer ans = new Answer(values);
        return ans;
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }
}