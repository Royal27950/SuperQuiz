package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Movies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }
    public void goHarryPotter(View v){ startActivity(new Intent(getApplicationContext(), HarryPotter.class)); finish();}
    public void goDeadpool(View v){ startActivity(new Intent(getApplicationContext(), Deadpool.class)); finish();}
}