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
    private Set<String> idEvals;

    private List<Element> facts = new ArrayList<>();

    public FactParser(String rulesXml) throws ParserConfigurationException, SAXException, IOException {
        loadXMLDocument(rulesXml);
        this.factRepository = new FactRepository();
        getElements();
        for (Element factElement : facts) {
            createFact(factElement);
        }
    }

    private Fact createFact(Element factElement) {
        String id = factElement.getAttribute("id");
        Element descriptionElement = (Element)factElement.getElementsByTagName("Description").item(0);
        String description = descriptionElement.getAttribute("value");
        //Fact fact = new Fact(id,description);
        Element evalsElement = (Element)factElement.getElementsByTagName("Evals").item(0);
        NodeList evalList = evalsElement.getElementsByTagName("Eval");
        Element evalElement;
        for (int i = 0;i < evalList.getLength(); i++) {
            evalElement = (Element)evalsElement.getElementsByTagName("Eval").item(i);
            String evalID = evalElement.getAttribute("id");
            String evalValue = evalsElement.getElementsByTagName("Eval").item(i).getTextContent();
            System.out.println(evalID);
            System.out.println(evalValue);
        }

        return null;
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
