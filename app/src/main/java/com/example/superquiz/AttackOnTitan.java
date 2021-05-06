package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AttackOnTitan extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;

    private ColorStateList textColorDefaultrb;


    private List<AttackOnTitanQuestion> attackOnTitanQuestionList;
    private int questionCounter;
    private int questionCountTotal;
    private AttackOnTitanQuestion currentQuestion;

    private int score;
    private boolean answered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack_on_titan);

        textViewQuestion = findViewById(R.id.question);
        textViewScore = findViewById(R.id.score);
        textViewQuestionCount = findViewById(R.id.count);
        textViewCountDown = findViewById(R.id.countdown);
        choice1 = findViewById(R.id.r1);
        choice2 = findViewById(R.id.r2);
        choice3 = findViewById(R.id.r3);
        choice4 = findViewById(R.id.r4);



        QuizDbHelper dbHelper = new QuizDbHelper(this);
        attackOnTitanQuestionList = dbHelper.getAllQuestion();
        questionCountTotal = attackOnTitanQuestionList.size();
        Collections.shuffle(attackOnTitanQuestionList);

        showNextQuestion();

        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if (choice1.equals(currentQuestion.getAnswerNumber())) {
                    score++;
                    textViewScore.setText("Score : " +score);
                    showNextQuestion();
                }*/showNextQuestion();
            }
        });
    }
    private void showNextQuestion(){

        if (questionCounter < questionCountTotal){
            currentQuestion = attackOnTitanQuestionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            choice1.setText(currentQuestion.getOption1());
            choice2.setText(currentQuestion.getOption2());
            choice3.setText(currentQuestion.getOption3());
            choice4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question " + questionCounter + "/" + questionCountTotal);
        }else{
            finishQuiz();
        }
    }
    public void finishQuiz(){
        finish();
    }
    //public void goQ2(View v){ startActivity(new Intent(getApplicationContext(), AttackOnTitan2.class));finish(); }
}