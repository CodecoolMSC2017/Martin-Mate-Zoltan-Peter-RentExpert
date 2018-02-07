package com.codecool;

import javafx.css.Rule;

import java.util.Iterator;
import java.util.List;

public class ESProvider {
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private List<Question> questions;
    private List<Fact> facts;
    private Iterator questionIterator;
    private Iterator factIterator;

    public ESProvider(RuleParser ruleParser, FactParser factParser) {
        this.ruleRepository = ruleParser.getRuleRepository();
        this.factRepository = factParser.getFactRepository();
        this.questions = ruleRepository.getQuestions();
        this.facts = factRepository.getFacts();
        this.questionIterator = ruleRepository.getIterator();
        this.factIterator = factRepository.getIterator();
    }

    public void collectAnswers() {

    }
}
