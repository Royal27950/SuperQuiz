package com.example.superquiz;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GuessTheSlogan extends AppCompatActivity {

    private GuessTheSloganQuestionBank mQuestionLibrary = new GuessTheSloganQuestionBank();

    private TextView mScoreViewGuessTheSlogan;   // view for current total score
    private TextView mQuestionView;  //current question to answer
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    private Button mButtonChoice4; // multiple choice 4 for mQuestionView

    private String mAnswer;  // correct answer for question in mQuestionView
    private int mScore = 0;  // current total score
    private int mQuestionNumber = 0; // current question number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_slogan);
        // setup screen for the first question with four alternative to answer
        mScoreViewGuessTheSlogan = (TextView)findViewById(R.id.scoreGuessTheSlogan);
        mQuestionView = (TextView)findViewById(R.id.questionGuessTheSlogan);
        mButtonChoice1 = (Button)findViewById(R.id.r1GuessTheSlogan);
        mButtonChoice2 = (Button)findViewById(R.id.r2GuessTheSlogan);
        mButtonChoice3 = (Button)findViewById(R.id.r3GuessTheSlogan);
        mButtonChoice4 = (Button)findViewById(R.id.r4GuessTheSlogan);

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
            finish();
        }
    }

    // show current total score for the user
    private void updateScore(int point) {
        mScoreViewGuessTheSlogan.setText(""+mScore+"/"+mQuestionLibrary.getLength());
    }

    public void onClick(View view) {
        //all logic for all answers buttons in one method
        Button answer = (Button) view;
        MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
        // if the answer is correct, increase the score
        if (answer.getText().equals(mAnswer)) {
            mScore = mScore + 1;
            mp.start();
            Toast.makeText(GuessTheSlogan.this, "Vrai !", Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(GuessTheSlogan.this, "Faux !", Toast.LENGTH_SHORT).show();
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