package com.codecool;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class FactParser extends XMLParser {
    private FactRepository factRepository;

    private List<Element> facts = new ArrayList<>();

    public FactParser(String rulesXml) throws ParserConfigurationException, SAXException, IOException {
        loadXMLDocument(rulesXml);
        this.factRepository = new FactRepository();
        getElements();
        for (Element factElement : facts) {
            factRepository.addFact(createFact(factElement));
        }
    }

    private Fact createFact(Element factElement) {
        String id = factElement.getAttribute("id");
        Element descriptionElement = (Element)factElement.getElementsByTagName("Description").item(0);
        String description = descriptionElement.getAttribute("value");
        Element evalsElement = (Element)factElement.getElementsByTagName("Evals").item(0);
        NodeList evalList = evalsElement.getElementsByTagName("Eval");
        Element evalElement;
        HashMap <String,Boolean> evalMap = new HashMap<>();
        for (int i = 0;i < evalList.getLength(); i++) {
            evalElement = (Element)evalsElement.getElementsByTagName("Eval").item(i);
            String evalID = evalElement.getAttribute("id");
            Boolean evalValue = Boolean.valueOf(evalsElement.getElementsByTagName("Eval").item(i).getTextContent());
            evalMap.put(evalID,evalValue);
        }
        return new Fact(id,description,evalMap);
    }


    private void getElements() {
        NodeList nList = dom.getElementsByTagName("Fact");

        for (int i = 0; i < nList.getLength();i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nNode;
                facts.add(e);
            }
        }
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }
}
