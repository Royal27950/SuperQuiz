package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GeneralCulture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_culture);
    }

    public void goHistory(View v){ startActivity(new Intent(getApplicationContext(), History.class)); }
    public void goGeography(View v){ startActivity(new Intent(getApplicationContext(), Geography.class)); }
}