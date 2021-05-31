package com.example.superquiz;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class GuessTheLogoQuestionBank {
    // declare list of Question objects
    List<GuessTheLogoQuestion> list = new ArrayList<>();
    QuizDbHelperGuessTheLogo myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperGuessTheLogo(context);
        list = myDataBaseHelper.getAllQuestionsListGuessTheLogo();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionGuessTheLogo(new GuessTheLogoQuestion("app/src/main/res/mipmap-hdpi/logoicon.png",
                    new String[]{"Mastercard", "Visa", "Carte bleue", "Carte gold"}, "Visa"));
            myDataBaseHelper.addInitialQuestionGuessTheLogo(new GuessTheLogoQuestion("Deviens ce que tu es.",
                    new String[]{"Hineken", "Heineken", "Heinneken", "Heneken"}, "Heineken"));
            myDataBaseHelper.addInitialQuestionGuessTheLogo(new GuessTheLogoQuestion("Ça coule de source.",
                    new String[]{"Peugeot", "Saab", "Ferrari", "Le roi lion"}, "Saab"));
            myDataBaseHelper.addInitialQuestionGuessTheLogo(new GuessTheLogoQuestion("Vivons mobile.",
                    new String[]{"Total", "Coquillage", "Shell", "Shield"}, "Shell"));
            myDataBaseHelper.addInitialQuestionGuessTheLogo(new GuessTheLogoQuestion("Passe le fun autour de toi !",
                    new String[]{"Starship", "Goldstar", "Converse", "Chrysler"}, "Converse"));

            list = myDataBaseHelper.getAllQuestionsListGuessTheLogo();//get list from database again

        }
    }
}
