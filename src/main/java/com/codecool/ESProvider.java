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
            String userAnswer = sc.nextLine();

            userAnswers.put(q.getId(),q.getEvalutedAnswer(userAnswer));
        }
    }

    public String evaluate() {
        List<Boolean> evaluatedAnswers =new ArrayList<>();
        evaluatedAnswers.add(userAnswers.get("money"));
        evaluatedAnswers.add(userAnswers.get("side"));
        evaluatedAnswers.add(userAnswers.get("family"));
        evaluatedAnswers.add(userAnswers.get("traffic"));
        evaluatedAnswers.add(userAnswers.get("public security"));
        evaluatedAnswers.add(userAnswers.get("lifestyle"));
        evaluatedAnswers.add(userAnswers.get("housetype"));


        for (Fact fact : facts) {
            List<Boolean> actualFactEvals =new ArrayList<>();
            actualFactEvals.add(fact.getEvals().get("money"));
            actualFactEvals.add(fact.getEvals().get("side"));
            actualFactEvals.add(fact.getEvals().get("family"));
            actualFactEvals.add(fact.getEvals().get("traffic"));
            actualFactEvals.add(fact.getEvals().get("public security"));
            actualFactEvals.add(fact.getEvals().get("lifestyle"));
            actualFactEvals.add(fact.getEvals().get("housetype"));
            if (actualFactEvals.equals(evaluatedAnswers)) {
                return fact.getDescription();
            }
        }
        return null;
    }
}
