package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    private final int SPLASHSCREEN_TIMEOUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Rediriger vers la page de connexion "Connect" après 3 secondes



        //Permet de lancer le runnable (donc le changement de page) après 3 secondes
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Connect.class);
                startActivity(intent);
                finish();
            }
        }, SPLASHSCREEN_TIMEOUT);



    }
}