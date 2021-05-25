package com.example.superquiz;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AttackOnTitan extends AppCompatActivity {

    private AttackOnTitanQuestionBank mQuestionLibrary = new AttackOnTitanQuestionBank();

    //public static  final String EXTRA_SCORE = "extraScore";

    private TextView mScoreViewAttackOnTitan;   // view for current total score
    private TextView mQuestionView;  //current question to answer
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    private Button mButtonChoice4; // multiple choice 4 for mQuestionView

    private String mAnswer;  // correct answer for question in mQuestionView
    private int mScore = 0;  // current total score
    private int mQuestionNumber = 0; // current question number
    private AttackOnTitan activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack_on_titan);
        // setup screen for the first question with four alternative to answer
        mScoreViewAttackOnTitan = (TextView)findViewById(R.id.scoreAttackOnTitan);
        mQuestionView = (TextView)findViewById(R.id.questionAttackOnTitan);
        mButtonChoice1 = (Button)findViewById(R.id.r1AttackOnTitan);
        mButtonChoice2 = (Button)findViewById(R.id.r2AttackOnTitan);
        mButtonChoice3 = (Button)findViewById(R.id.r3AttackOnTitan);
        mButtonChoice4 = (Button)findViewById(R.id.r4AttackOnTitan);
        this.activity = this;



        mQuestionLibrary.initQuestions(getApplicationContext());
        updateQuestion();
        // show current total score for the user
        updateScore(mScore);
    }

    private void updateQuestion(){
        // check if we are not outside array bounds for questions
        if(mQuestionNumber<mQuestionLibrary.getLength() ){
            // set the text for new question,
            // and new 4 alternative to answer on four buttons
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {

            QuizDbHelper quizDbHelper = new QuizDbHelper(AttackOnTitan.this);
            quizDbHelper.delete();
            //quizDbHelper.addHighScore(mScore);
            AlertDialog.Builder viewScore = new AlertDialog.Builder(this);
            viewScore.setTitle("Bravo !");
            viewScore.setMessage("Vous avez eu " +mScore+"/"+mQuestionLibrary.getLength() + " points !");
            viewScore.setPositiveButton("Voir mon score", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    /*Intent resultIntent = new Intent(getApplicationContext(), Ranking.class);
                    resultIntent.putExtra(EXTRA_SCORE, mScore);
                    setResult(RESULT_OK, resultIntent);*/
                    finish();
                }
            });
            viewScore.create().show();
        }
    }

    // show current total score for the user
    private void updateScore(int point) {
        mScoreViewAttackOnTitan.setText(""+mScore+"/"+mQuestionLibrary.getLength());
    }

    public void onClick(View view) {
        //all logic for all answers buttons in one method
        Button answer = (Button) view;
        MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        // if the answer is correct, increase the score
        if (answer.getText().equals(mAnswer)) {
            mScore = mScore + 1;
            mp.start();
            Toast.makeText(AttackOnTitan.this, "Vrai !", Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(AttackOnTitan.this, "Faux !", Toast.LENGTH_SHORT).show();
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

            // Vibrate for 400 milliseconds
            v.vibrate(400);
        }

        // show current total score for the user
        updateScore(mScore);
        // once user answer the question, we move on to the next one, if any
        updateQuestion();
    }
}