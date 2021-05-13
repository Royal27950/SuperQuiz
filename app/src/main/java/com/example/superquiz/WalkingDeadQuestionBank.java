package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class WalkingDeadQuestionBank {

    // declare list of Question objects
    List <WalkingDeadQuestion> list = new ArrayList<>();
    QuizDbHelperWalkingDead myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperWalkingDead(context);
        list = myDataBaseHelper.getAllQuestionsListWalkingDead();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionWalkingDead(new WalkingDeadQuestion("Comment les personnages appellent-ils le plus communément les zombies ?",
                    new String[]{"Des macabés", "Des pourris", "Des rôdeurs", "Des monstres"}, "Des rôdeurs"));
            myDataBaseHelper.addInitialQuestionWalkingDead(new WalkingDeadQuestion("Qui n'est pas mort ?",
                    new String[]{"Abraham", "Merle", "Lori", "Maggie"}, "Maggie"));
            myDataBaseHelper.addInitialQuestionWalkingDead(new WalkingDeadQuestion("Quel est la cause de l'épidémie ?",
                    new String[]{"Un pangolin", "Un spore venu de l'espace", "Un virus échappé d'un laboratoire", "On ne sait pas"}, "On ne sait pas"));
            myDataBaseHelper.addInitialQuestionWalkingDead(new WalkingDeadQuestion("Comment s'appelle le clan qui vit au contact des rôdeurs ?",
                    new String[]{"Les cacheurs", "Les chuchoteurs", "Les sans peur", "Les suiveurs"}, "Les chuchoteurs"));
            myDataBaseHelper.addInitialQuestionWalkingDead(new WalkingDeadQuestion("Qui a tué Abraham ?",
                    new String[]{"Megan", "Un rôdeur", "Negan", "Le Gouverneur"}, "Negan"));

            list = myDataBaseHelper.getAllQuestionsListWalkingDead();//get list from database again

        }
    }

}