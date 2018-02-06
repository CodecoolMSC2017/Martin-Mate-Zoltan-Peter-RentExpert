package com.codecool;

public class Question {
    private String id;
    private String question;
    private Answer answer;

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

    public boolean getEvalutedAnswer(String input) {
        int answers = answer.getValues().size();
        if (answer.evaluateAnswerByInput(input)) {
            for (int i = 0; i < answers) {
                if (answers[i] instanceof SingleValue) {

                }
            }
        }

    }
}
