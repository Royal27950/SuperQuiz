package com.example.superquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class PokemonQuestionBank {

    // declare list of Question objects
    List <PokemonQuestion> list = new ArrayList<>();
    QuizDbHelperPokemon myDataBaseHelper;

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
        myDataBaseHelper = new QuizDbHelperPokemon(context);
        list = myDataBaseHelper.getAllQuestionsListPokemon();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestionPokemon(new PokemonQuestion("D'où vient Sacha ?",
                    new String[]{"Jadielle", "Bourg-Palette", "Neuilly-sur-Seine", "Argenta"}, "Bourg-Palette"));
            myDataBaseHelper.addInitialQuestionPokemon(new PokemonQuestion("Quel est le fidèle Pokémon de Sacha ?",
                    new String[]{"Pikatchu", "Pikachou", "Pikachu", "Pikatchou"}, "Pikachu"));
            myDataBaseHelper.addInitialQuestionPokemon(new PokemonQuestion("Combien de génération de Pokémon existe-t-il ?",
                    new String[]{"10", "8", "12", "14"}, "8"));
            myDataBaseHelper.addInitialQuestionPokemon(new PokemonQuestion("A quel Pokémon Racaillou est-il immunisé ?",
                    new String[]{"Carapuce", "Bulbizarre", "Salamèche", "Pikachu"}, "Pikachu"));
            myDataBaseHelper.addInitialQuestionPokemon(new PokemonQuestion("Combien y a t-il de Pokémon ?",
                    new String[]{"entre 800 et 849", "entre 850 et 899", "entre 900 et 949", "entre 950 et 999"}, "entre 850 et 899"));

            list = myDataBaseHelper.getAllQuestionsListPokemon();//get list from database again

        }
    }

}