package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class GeographyQuestionBank {

    // declare list of Question objects
    List <GeographyQuestion> list = new ArrayList<>();
    QuizDbHelperGeography myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperGeography(context);
        list = myDataBaseHelper.getAllQuestionsListGeography();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionGeography(new GeographyQuestion("Quel est la capitale de l'Australie ?",
                    new String[]{"Sydney", "Melbourne", "Canberra", "Paris"}, "Canberra"));
            myDataBaseHelper.addInitialQuestionGeography(new GeographyQuestion("Quel pays n'est pas limitrophe de la Chine ?",
                    new String[]{"La Russie", "Le Pakistan", "Le Vietnam", "La Corée du sud"}, "La Corée du sud"));
            myDataBaseHelper.addInitialQuestionGeography(new GeographyQuestion("Quel est le pays le plus grand du monde ?",
                    new String[]{"La Chine", "L'Afrique", "La Russie", "Les États-Unis"}, "La Russie"));
            myDataBaseHelper.addInitialQuestionGeography(new GeographyQuestion("Quel est le fuseau horaire de Chicago ?",
                    new String[]{"- 6H", "+ 10H", "+ 5H", "- 25H"}, "- 6H"));
            myDataBaseHelper.addInitialQuestionGeography(new GeographyQuestion("De quel forme est la Terre ?",
                    new String[]{"Ronde", "Plate", "Ronde aplatie", "Ovale"}, "Ronde aplatie"));

            list = myDataBaseHelper.getAllQuestionsListGeography();//get list from database again

        }
    }

}