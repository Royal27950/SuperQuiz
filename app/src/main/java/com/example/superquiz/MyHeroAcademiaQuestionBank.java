package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class MyHeroAcademiaQuestionBank {

    // declare list of Question objects
    List <MyHeroAcademiaQuestion> list = new ArrayList<>();
    QuizDbHelperMyHeroAcademia myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperMyHeroAcademia(context);
        list = myDataBaseHelper.getAllQuestionsListMyHeroAcademia();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionMyHeroAcademia(new MyHeroAcademiaQuestion("Comment s'appelle le pouvoir des personnages ?",
                    new String[]{"L'alter", "Le fruit du démon", "Le bankaï", "Le souffle"}, "L'alter"));
            myDataBaseHelper.addInitialQuestionMyHeroAcademia(new MyHeroAcademiaQuestion("Quel est le pouvoir d'All Might ?",
                    new String[]{"All FOR ONE", "FOR ALL ONE", "ONE FOR ALL", "FOR ONE ALL"}, "ONE FOR ALL"));
            myDataBaseHelper.addInitialQuestionMyHeroAcademia(new MyHeroAcademiaQuestion("Qui possède l'alter 'Grenouille' ?",
                    new String[]{"Tsuyu", "Eijiro", "Minoru", "Mezou"}, "Tsuyu"));
            myDataBaseHelper.addInitialQuestionMyHeroAcademia(new MyHeroAcademiaQuestion("Qui est à la tête de la Mafia ?",
                    new String[]{"Tomura Shigaraki", "Himiko Toga", "Kai Chisaki", "All For One"}, "Kai Chisaki"));
            myDataBaseHelper.addInitialQuestionMyHeroAcademia(new MyHeroAcademiaQuestion("Qui est le proviseur de l'université de UA ?",
                    new String[]{"Le héro numéro 1", "Un ancien super vilain", "Le personnage principal", "Une souris"}, "Une souris"));

            list = myDataBaseHelper.getAllQuestionsListMyHeroAcademia();//get list from database again

        }
    }

}