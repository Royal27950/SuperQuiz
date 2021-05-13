package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class GuessTheSloganQuestionBank {

    // declare list of Question objects
    List <GuessTheSloganQuestion> list = new ArrayList<>();
    QuizDbHelperGuessTheSlogan myDataBaseHelper;

    // method returns number of questions in list
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }



    public void initQuestions(Context context) {
        myDataBaseHelper = new QuizDbHelperGuessTheSlogan(context);
        list = myDataBaseHelper.getAllQuestionsListGuessTheSlogan();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionGuessTheSlogan(new GuessTheSloganQuestion("Se réinventer chaque jour ...",
                    new String[]{"Yves Rocher", "Sephora", "Always", "Pampers"}, "Yves Rocher"));
            myDataBaseHelper.addInitialQuestionGuessTheSlogan(new GuessTheSloganQuestion("Deviens ce que tu es.",
                    new String[]{"Adidas", "Ralph Lauren", "Lacoste", "Pull and Bear"}, "Lacoste"));
            myDataBaseHelper.addInitialQuestionGuessTheSlogan(new GuessTheSloganQuestion("Ça coule de source.",
                    new String[]{"Evian", "Contrex", "Cristaline", "Volvic"}, "Cristaline"));
            myDataBaseHelper.addInitialQuestionGuessTheSlogan(new GuessTheSloganQuestion("Vivons mobile.",
                    new String[]{"Orange", "Free", "Bouygues", "SFR"}, "SFR"));
            myDataBaseHelper.addInitialQuestionGuessTheSlogan(new GuessTheSloganQuestion("Passe le fun autour de toi !",
                    new String[]{"Fanta", "Pepsi", "Orangina", "Oasis"}, "Fanta"));

            list = myDataBaseHelper.getAllQuestionsListGuessTheSlogan();//get list from database again

        }
    }

}