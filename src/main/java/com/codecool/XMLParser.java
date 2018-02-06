package com.codecool;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;

import java.io.IOException;

public abstract class XMLParser {

    private static final DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();

    protected Document dom;
    public void loadXMLDocument(String filename) throws IOException, SAXException, ParserConfigurationException {
        File fXmlFile = new File(filename + ".xml");
        DocumentBuilder dBuilder = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();

        dom = doc;
    }
}