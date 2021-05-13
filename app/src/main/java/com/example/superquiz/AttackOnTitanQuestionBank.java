package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class AttackOnTitanQuestionBank {

    // declare list of Question objects
    List <AttackOnTitanQuestion> list = new ArrayList<>();
    QuizDbHelper myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelper(context);
        list = myDataBaseHelper.getAllQuestionsListAttackOnTitan();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionAttackOnTitan(new AttackOnTitanQuestion("Quel Titan n'existe pas ?",
                    new String[]{"Le Bestial", "Le Mâchoire", "L'Armure", "Le Marteau"}, "L'Armure"));
            myDataBaseHelper.addInitialQuestionAttackOnTitan(new AttackOnTitanQuestion("Qui tue la mère d'Eren Jäger ?",
                    new String[]{"Dinah Fritz", "Eren Jäger", "Kenny", "Helmut Fritz"}, "Dinah Fritz"));
            myDataBaseHelper.addInitialQuestionAttackOnTitan(new AttackOnTitanQuestion("Qui est le nouveau Colossal ?",
                    new String[]{"Bertolt", "Mikasa", "Kenny", "Armin"}, "Armin"));
            myDataBaseHelper.addInitialQuestionAttackOnTitan(new AttackOnTitanQuestion("Quel district se trouve au sain du mur Maria ?",
                    new String[]{"District de Trost", "District de Stohess", "District de Shiganshina", "District d'Utopia"}, "District de Shiganshina"));
            myDataBaseHelper.addInitialQuestionAttackOnTitan(new AttackOnTitanQuestion("Qui a tué Sasha ?",
                    new String[]{"Reiner", "Gaby", "Livaï", "Sieg"}, "Gaby"));

            list = myDataBaseHelper.getAllQuestionsListAttackOnTitan();//get list from database again

        }
    }

}