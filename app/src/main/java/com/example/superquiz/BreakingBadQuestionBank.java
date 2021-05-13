package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class BreakingBadQuestionBank {

    // declare list of Question objects
    List <BreakingBadQuestion> list = new ArrayList<>();
    QuizDbHelperBreakingBad myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperBreakingBad(context);
        list = myDataBaseHelper.getAllQuestionsListBreakingBad();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionBreakingBad(new BreakingBadQuestion("Quel boulot faisait Walter White avant ?",
                    new String[]{"Professeur de maths", "Avocat", "Professeur de chimie", "Chômeur"}, "Professeur de chimie"));
            myDataBaseHelper.addInitialQuestionBreakingBad(new BreakingBadQuestion("Comment Walter White blanchi-t-il son argent ?",
                    new String[]{"Grâce au drop shipping", "Grâce à Saul Goodman", "Grâce à sa station de lavage", "Grâce à son fils"}, "Grâce à sa station de lavage"));
            myDataBaseHelper.addInitialQuestionBreakingBad(new BreakingBadQuestion("À combien est estimé la fortune de Walter White ?",
                    new String[]{"100 millions de dollars", "80 millions de dollars", "1 million de dollars", "50 millions de dollars"}, "80 millions de dollars"));
            myDataBaseHelper.addInitialQuestionBreakingBad(new BreakingBadQuestion("Le slip de Walter White a été vendu aux enchères, sais-tu à combien ?",
                    new String[]{"5.400 dollars", "8.600 dollars", "9.900 dollars", "10.200 dollars"}, "9.900 dollars"));
            myDataBaseHelper.addInitialQuestionBreakingBad(new BreakingBadQuestion("Combien de fois Jesse dit-il 'Bitch' dans la série ?",
                    new String[]{"16 fois", "29 fois", "47 fois", "64 fois"}, "47 fois"));

            list = myDataBaseHelper.getAllQuestionsListBreakingBad();//get list from database again

        }
    }

}