package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class HarryPotterQuestionBank {

    // declare list of Question objects
    List <HarryPotterQuestion> list = new ArrayList<>();
    QuizDbHelperHarryPotter myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperHarryPotter(context);
        list = myDataBaseHelper.getAllQuestionsListHarryPotter();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionHarryPotter(new HarryPotterQuestion("Comment s'appelle la chouette de Harry ?",
                    new String[]{"Hedvige", "Edwige", "Hedwige", "Hedvij"}, "Hedwige"));
            myDataBaseHelper.addInitialQuestionHarryPotter(new HarryPotterQuestion("Qui est Sirius Black pour Harry ?",
                    new String[]{"Son père", "Son oncle", "Son parrain", "Son frère"}, "Son parrain"));
            myDataBaseHelper.addInitialQuestionHarryPotter(new HarryPotterQuestion("Comment s'appelle l'hipogriffe de Hagrid ?",
                    new String[]{"Duck", "Muck", "Fuck", "Buck"}, "Buck"));
            myDataBaseHelper.addInitialQuestionHarryPotter(new HarryPotterQuestion("Dans quelle maison est Luna Lovegood ?",
                    new String[]{"Serdaigle", "Gryffondor", "Poufsouffle", "Serpentard"}, "Serdaigle"));
            myDataBaseHelper.addInitialQuestionHarryPotter(new HarryPotterQuestion("Qui abrite Voldemort dans le premier film ?",
                    new String[]{"Rogue", "Quirrel", "McGonagall", "Hagrid"}, "Quirrel"));

            list = myDataBaseHelper.getAllQuestionsListHarryPotter();//get list from database again

        }
    }

}