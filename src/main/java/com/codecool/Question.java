package com.codecool;

import java.util.HashMap;

public class Question {
    private String id;
    private String question;
    private Answer answer;
    private HashMap<String, Boolean> answerToQuestion;

    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public boolean getEvalutedAnswer(String input) { // függvényhívásnál 3-4 bekérés (counter számláló változó segítségével), ha sikertelen a próbálkozás akkor InvalidOperationException
        if (answer.evaluateAnswerByInput(input)) {
            for (Value value: answer.getValues()) {
                if (value instanceof SingleValue) {
                    if (value.getInputPattern().get(0).equals(input))
                        answerToQuestion.put(id, value.getSelectionType());
                        return value.getSelectionType();
                } else {
                    for (int i = 0; i < value.getInputPattern().size(); i++) {
                        if (input.equals(value.getInputPattern().get(i))) {
                            answerToQuestion.put(id, value.getSelectionType());
                            return value.getSelectionType();
                        }
                    }
                }
            }
        }
        return false;
    }
}
