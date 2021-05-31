package com.example.superquiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.ConfigurationCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class Ranking extends AppCompatActivity {

    /*private static final int REQUEST_CODE_QUIZ=1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    private int highScore;*/

    Spinner listCategory;
    String[] spinnerOptions = {"Histoire", "Géographie", "L'Attaque des Titans", "Pokémon", "Tokyo Ghoul", "My Hero Academia",
            "One Piece","Devine le logo", "Devine le slogan",  "The Walking Dead", "Breaking Bad", "Harry Potter", "Deadpool"};
    TextView country, userMail, hightScoreSnkText;
    String hightScoreSnk;
    Locale locale;
    //get the current user's email
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid = user.getEmail();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        AttackOnTitanQuestion attackOnTitanQuestion = new AttackOnTitanQuestion();

        listCategory = findViewById(R.id.listCategory);
        country = findViewById(R.id.country);
        userMail = findViewById(R.id.userMail);
        hightScoreSnkText = findViewById(R.id.score);
        //loadHighscore();
        locale = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
        //retrieves the user's connection country
        country.setText(locale.getDisplayCountry());
        userMail.setText(uid);

        hightScoreSnk = attackOnTitanQuestion.getHighScore();

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listCategory.setAdapter(adapter);

        //displays the score according to the question category
        listCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://it's a test
                        hightScoreSnkText.setText(hightScoreSnk);
                        break;
                    case 1:
                        hightScoreSnkText.setText("geo");
                        break;
                    case 2:
                        hightScoreSnkText.setText("snk");
                        break;
                    case 3:
                        hightScoreSnkText.setText("pkm");
                        break;
                    case 4:
                        hightScoreSnkText.setText("tokyo");
                        break;
                    case 5:
                        hightScoreSnkText.setText("mha");
                        break;
                    case 6:
                        hightScoreSnkText.setText("op");
                        break;
                    case 7:
                        hightScoreSnkText.setText("logo");
                        break;
                    case 8:
                        hightScoreSnkText.setText("slogan");
                        break;
                    case 9:
                        hightScoreSnkText.setText("twd");
                        break;
                    case 10:
                        hightScoreSnkText.setText("bb");
                        break;
                    case 11:
                        hightScoreSnkText.setText("hp");
                        break;
                    case 12:
                        hightScoreSnkText.setText("deadpool");
                        break;
                }
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){

            }

        });

    }
    public void goBack(View v){ startActivity(new Intent(getApplicationContext(), MainActivity.class)); finish();}
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == REQUEST_CODE_QUIZ){
            if ( resultCode == RESULT_OK){
                int score = data.getIntExtra(AttackOnTitan.EXTRA_SCORE, 0);
                if (score > highScore){
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadHighscore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        highScore = prefs.getInt(KEY_HIGHSCORE, 0);
        hightScoreSnk.setText(highScore);
    }

    private void updateHighscore(int highscoreNew){
        highScore = highscoreNew;
        hightScoreSnk.setText(highScore);

        SharedPreferences pref = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(KEY_HIGHSCORE, highScore);
        editor.apply();
    }*/
}