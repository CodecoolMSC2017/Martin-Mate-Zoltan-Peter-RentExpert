package com.codecool;

import javafx.css.Rule;

import java.util.List;

public class ESProvider {
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private List<Question> questions;
    private List<Fact> facts;
    private QuestionIterator qi;
    private FactIterator fi;

    public ESProvider(RuleParser ruleParser, FactParser factParser) {
        this.ruleRepository = ruleParser.getRuleRepository();
        this.factRepository = factParser.getFactRepository();
        this.questions = ruleRepository.getQuestions();
        this.facts = factRepository.getFacts();
        this.qi = new QuestionIterator(questions);
        this.fi = new FactIterator(facts);
    }
}
