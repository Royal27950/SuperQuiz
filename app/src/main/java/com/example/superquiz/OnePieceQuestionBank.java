package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class OnePieceQuestionBank {

    // declare list of Question objects
    List <OnePieceQuestion> list = new ArrayList<>();
    QuizDbHelperOnePiece myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperOnePiece(context);
        list = myDataBaseHelper.getAllQuestionsListOnePiece();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionOnePiece(new OnePieceQuestion("Où est né Luffy ?",
                    new String[]{"East Blue", "North Blue", "West Blue", "South Blue"}, "East Blue"));
            myDataBaseHelper.addInitialQuestionOnePiece(new OnePieceQuestion("Quel bâtiment se situe sur Red Line ?",
                    new String[]{"Marine Ford", "Impel Down", "Mary Geoise", "La maison de Luffy"}, "Mary Geoise"));
            myDataBaseHelper.addInitialQuestionOnePiece(new OnePieceQuestion("Comment s'appelle le fruit du démon de Luffy ?",
                    new String[]{"GOMI GOMI NO MU", "GOMU GOMU NO MI", "GONO GONO MI NU", "GOGO GOGO MI NU"}, "GOMU GOMU NO MI"));
            myDataBaseHelper.addInitialQuestionOnePiece(new OnePieceQuestion("Quel personnage ne fait pas parti des 4 Empereurs ?",
                    new String[]{"Shanks", "Kaido", "Big Mom", "Barbe Blanche"}, "Barbe Blanche"));
            myDataBaseHelper.addInitialQuestionOnePiece(new OnePieceQuestion("Comment s'appellent les pirates qui ont passé un pacte avec la Marine ?",
                    new String[]{"Les grands Corsaires", "Les Empereurs", "Ils n'ont pas de titre spécial", "Les Amiraux"}, "Les grands Corsaires"));

            list = myDataBaseHelper.getAllQuestionsListOnePiece();//get list from database again

        }
    }

}