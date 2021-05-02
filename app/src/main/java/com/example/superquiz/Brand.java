package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Brand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
    }
    public void goGuessTheLogo(View v){ startActivity(new Intent(getApplicationContext(), GuessTheLogo.class));finish(); }
    public void goGuessTheSlogan(View v){ startActivity(new Intent(getApplicationContext(), GuessTheSlogan.class)); finish();}
}