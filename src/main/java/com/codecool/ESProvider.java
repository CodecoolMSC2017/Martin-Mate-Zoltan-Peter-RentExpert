package com.codecool;

import javafx.css.Rule;

import java.util.*;

public class ESProvider {
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private List<Question> questions;
    private List<Fact> facts;
    private Iterator<Question> questionIterator;
    private Iterator<Fact> factIterator;

    private Map<String, Boolean> userAnswers = new HashMap<>();

    public ESProvider(RuleParser ruleParser, FactParser factParser) {
        this.ruleRepository = ruleParser.getRuleRepository();
        this.factRepository = factParser.getFactRepository();
        this.questions = ruleRepository.getQuestions();
        this.facts = factRepository.getFacts();
        this.questionIterator = ruleRepository.getIterator();
        this.factIterator = factRepository.getIterator();
    }

    public void collectAnswers() {
        while (questionIterator.hasNext()) {
            Question q = questionIterator.next();
            System.out.println(q.getQuestion());
            System.out.println("Answers: " + q.getAnswer().getValues());
            Scanner sc = new Scanner(System.in);
            String userAnswer = "yes"; //sc.nextLine ÁTKELL IRNI SZKENNERGENYORA a teszt miatt "yes"

            //userAnswers.put(q.getId(),q.getEvalutedAnswer(userAnswer)); meg nem jo!
        }
        System.out.println(userAnswers);
    }

    public String evaluate() {
        Set<Boolean> evaluatedAnswers = (Set<Boolean>) userAnswers.values();

        for (Fact fact : facts) {
            Set<Boolean> actualFactEvals = (Set<Boolean>) fact.getEvals().values();
            if (actualFactEvals.containsAll(evaluatedAnswers)) {
                return fact.getDescription();
            }
        }
        return null;
    }
}
