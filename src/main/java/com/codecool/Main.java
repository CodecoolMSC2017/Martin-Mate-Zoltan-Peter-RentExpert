package com.codecool;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        ESProvider ep = new ESProvider(new RuleParser("Rules"),new FactParser("Facts"));
        try {
            ep.collectAnswers();
            if (ep.evaluate() == null) {
                System.out.println("\nThere is no proper district for you!");
            } else {
                System.out.println("\nYour best possible choice is: " + ep.evaluate());
            }
        } catch (Exception e) {
            System.out.println("Invalid operation!");
        }
    }
}
