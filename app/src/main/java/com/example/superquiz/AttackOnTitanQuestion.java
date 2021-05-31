package com.example.superquiz;
// class AttackOnTitanQuestion to describe on question for test:
// question itself, multiple choices to answer, correct answer, and the best score (test)
public class AttackOnTitanQuestion {

    private String question;
    private String[] choice = new String[4];
    private String answer;
    private String highScore;

    public AttackOnTitanQuestion() {

    }
    public AttackOnTitanQuestion(String question, String[] choices, String answer) {
        this.question = question;
        this.choice[0] = choices[0];
        this.choice[1] = choices[1];
        this.choice[2] = choices[2];
        this.choice[3] = choices[3];
        this.answer = answer;
        this.highScore = highScore;
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

    /* these are tests to add the best scores to the database */
    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }
}
