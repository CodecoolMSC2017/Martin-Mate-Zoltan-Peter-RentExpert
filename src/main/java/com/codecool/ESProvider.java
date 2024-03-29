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

    public void collectAnswers() throws Exception {
        while (questionIterator.hasNext()) {
            Question q = questionIterator.next();
            System.out.println(q.getQuestion());
            System.out.println("Valid answers: " + q.getAnswer().getValues());
            Scanner sc = new Scanner(System.in);
            int counter = 0;
            while (counter < 3) {
                String userAnswer = sc.nextLine();
                if (counter == 2) {
                    throw new Exception();
                }
                if (!(q.getAnswer().evaluateAnswerByInput(userAnswer))) {
                    System.out.println("Invalid answer, please choose from the given ones!");
                    counter++;
                } else {
                    userAnswers.put(q.getId(),q.getEvalutedAnswer(userAnswer));
                    break;
                }
            }

        }
    }

    public String evaluate() {
        List<Boolean> evaluatedAnswers =new ArrayList<>();
        if (userAnswers.get("money").equals(false)) {
            evaluatedAnswers.add(userAnswers.get("money"));
            evaluatedAnswers.add(userAnswers.get("side"));
            evaluatedAnswers.add(userAnswers.get("family"));
            evaluatedAnswers.add(userAnswers.get("traffic"));
            evaluatedAnswers.add(userAnswers.get("public security"));
            evaluatedAnswers.add(userAnswers.get("lifestyle"));
            evaluatedAnswers.add(userAnswers.get("housetype"));
        }
        else {
            evaluatedAnswers.add(userAnswers.get("side"));
            evaluatedAnswers.add(userAnswers.get("family"));
            evaluatedAnswers.add(userAnswers.get("traffic"));
            evaluatedAnswers.add(userAnswers.get("public security"));
            evaluatedAnswers.add(userAnswers.get("lifestyle"));
            evaluatedAnswers.add(userAnswers.get("housetype"));
        }

        String districts ="";
        for (Fact fact : facts) {
            List<Boolean> actualFactEvals =new ArrayList<>();
            if(userAnswers.get("money").equals(false)) {
                actualFactEvals.add(fact.getEvals().get("money"));
                actualFactEvals.add(fact.getEvals().get("side"));
                actualFactEvals.add(fact.getEvals().get("family"));
                actualFactEvals.add(fact.getEvals().get("traffic"));
                actualFactEvals.add(fact.getEvals().get("public security"));
                actualFactEvals.add(fact.getEvals().get("lifestyle"));
                actualFactEvals.add(fact.getEvals().get("housetype"));
            }
            else {
                actualFactEvals.add(fact.getEvals().get("side"));
                actualFactEvals.add(fact.getEvals().get("family"));
                actualFactEvals.add(fact.getEvals().get("traffic"));
                actualFactEvals.add(fact.getEvals().get("public security"));
                actualFactEvals.add(fact.getEvals().get("lifestyle"));
                actualFactEvals.add(fact.getEvals().get("housetype"));
            }
            if (actualFactEvals.equals(evaluatedAnswers)) {
                if (districts.length() < 1 ) {
                    districts += fact.getDescription();
                }
                else {
                    districts += " or " + fact.getDescription();
                }
            }
        }
        return districts;
    }
}
