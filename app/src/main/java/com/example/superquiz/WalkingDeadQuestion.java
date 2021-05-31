package com.example.superquiz;
// class WalkingDeadQuestion to describe on question for test:
// question itself, multiple choices to answer, and correct answer
public class WalkingDeadQuestion {

    private String question;
    private String[] choice = new String[4];
    private String answer;

    public WalkingDeadQuestion() {

    }
    public WalkingDeadQuestion(String question, String[] choices, String answer) {
        this.question = question;
        this.choice[0] = choices[0];
        this.choice[1] = choices[1];
        this.choice[2] = choices[2];
        this.choice[3] = choices[3];
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoice(int i) {
        return choice[i];
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setChoice(int i, String choice) {
        this.choice[i] = choice;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
