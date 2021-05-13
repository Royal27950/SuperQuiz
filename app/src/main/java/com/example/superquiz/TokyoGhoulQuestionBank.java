package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TokyoGhoulQuestionBank {

    // declare list of Question objects
    List <TokyoGhoulQuestion> list = new ArrayList<>();
    QuizDbHelperTokyoGhoul myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperTokyoGhoul(context);
        list = myDataBaseHelper.getAllQuestionsListTokyoGhoul();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionTokyoGhoul(new TokyoGhoulQuestion("Comment Kaneki est-il devenu une goule ?",
                    new String[]{"En ayant un rapport sexuel avec un goule", "En se faisant mordre par une goule", "En se faisant implanter un organe de goule", "Il est né goule"}, "En se faisant implanter un organe de goule"));
            myDataBaseHelper.addInitialQuestionTokyoGhoul(new TokyoGhoulQuestion("Comment s'appelle l'organe dans le dos des goules ?",
                    new String[]{"Un Kagune", "Un Ukaku", "Une Hinami", "Des tentacules"}, "Un Kagune"));
            myDataBaseHelper.addInitialQuestionTokyoGhoul(new TokyoGhoulQuestion("Quel est le rang maximal d'un goule ?",
                    new String[]{"Rang Z", "Rang 100", "Rang S", "Rang SSS"}, "Rang SSS"));
            myDataBaseHelper.addInitialQuestionTokyoGhoul(new TokyoGhoulQuestion("Qui torture Kaneki Ken ?",
                    new String[]{"Yamori", "Ulquiorra", "Touka", "Kureo"}, "Yamori"));
            myDataBaseHelper.addInitialQuestionTokyoGhoul(new TokyoGhoulQuestion("Que mange les goules ?",
                    new String[]{"Vegan", "Des humains", "Des aliments normaux", "Des tractopelles"}, "Des humains"));

            list = myDataBaseHelper.getAllQuestionsListTokyoGhoul();//get list from database again

        }
    }

}