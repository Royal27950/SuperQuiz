package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Series extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
    }
    public void goWalkingDead(View v){ startActivity(new Intent(getApplicationContext(), WalkingDead.class)); finish(); }
    public void goBreakingBad(View v){ startActivity(new Intent(getApplicationContext(), BreakingBad.class)); finish();}
}