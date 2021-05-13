package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DeadpoolQuestionBank {

    // declare list of Question objects
    List <DeadpoolQuestion> list = new ArrayList<>();
    QuizDbHelperDeadpool myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperDeadpool(context);
        list = myDataBaseHelper.getAllQuestionsListDeadpool();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionDeadpool(new DeadpoolQuestion("Quel est le vrai nom de Deadpool ?",
                    new String[]{"Jack Bruce", "Wide Wilson", "Peter Jack", "XxProKillerxX"}, "Wide Wilson"));
            myDataBaseHelper.addInitialQuestionDeadpool(new DeadpoolQuestion("D'où lui vient l'inspiration du nom 'Deadpool' ?",
                    new String[]{"Un gosse lui a dit", "Dans un rêve", "Un tableau dans un bar", "Il a cherché sur Internet"}, "Un tableau dans un bar"));
            myDataBaseHelper.addInitialQuestionDeadpool(new DeadpoolQuestion("Pourquoi a-t-il un costume rouge ?",
                    new String[]{"Pour faire peur", "Parce qu'il n'y avait plus que ça au magasin", "Pourquoi pas ?", "Pour ne pas laver le sang"}, "Pour ne pas laver le sang"));
            myDataBaseHelper.addInitialQuestionDeadpool(new DeadpoolQuestion("Comment s'appelle son ennemi ?",
                    new String[]{"Todd", "Françis", "Franck", "Ryan"}, "Françis"));
            myDataBaseHelper.addInitialQuestionDeadpool(new DeadpoolQuestion("À quoi ressemble-t-il ?",
                    new String[]{"Un mec sexy", "Une pomme de terre", "Un pruneau", "À toi"}, "Un pruneau"));

            list = myDataBaseHelper.getAllQuestionsListDeadpool();//get list from database again

        }
    }

}