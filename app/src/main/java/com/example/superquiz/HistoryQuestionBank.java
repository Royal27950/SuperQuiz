package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class HistoryQuestionBank {

    // declare list of Question objects
    List <HistoryQuestion> list = new ArrayList<>();
    QuizDbHelperHistory myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperHistory(context);
        list = myDataBaseHelper.getAllQuestionsListHistory();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionHistory(new HistoryQuestion("En quelle année à eu lieu le couronnement de Charlemagnes ?",
                    new String[]{"1000 après J-C", "800 après J-C", "200 avant J-C", "n'a pas pu avoir lieu à cause du COVID"}, "800 après J-C"));
            myDataBaseHelper.addInitialQuestionHistory(new HistoryQuestion("En quelle année à commencé la Vième République ?",
                    new String[]{"1958", "1948", "1955", "1950"}, "1958"));
            myDataBaseHelper.addInitialQuestionHistory(new HistoryQuestion("Qui a été président de la République de 1995 à 2007 ?",
                    new String[]{"Nicolas Sarkozy", "François Mitterand", "Jacques Chirac", "Emmanuel Macron"}, "Jacques Chirac"));
            myDataBaseHelper.addInitialQuestionHistory(new HistoryQuestion("De quand date l'apparition de l'Homme ?",
                    new String[]{"Il y a 2,5 millions d'années", "Il y a 2,5 milliards d'années", "Il y a 2021 années", "Il y a 3 millions d'années"}, "Il y a 2,5 millions d'années"));
            myDataBaseHelper.addInitialQuestionHistory(new HistoryQuestion("Comment est mort Louis XV ?",
                    new String[]{"Mangé par un chien", "Guillotiné", "OKLM à Versailles", "Noyé dans son bain"}, "OKLM à Versailles"));

            list = myDataBaseHelper.getAllQuestionsListHistory();//get list from database again

        }
    }

}