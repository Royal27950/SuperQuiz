package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TokyoGhoul2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tokyo_ghoul2);
    }
    public void goQ3(View v){ startActivity(new Intent(getApplicationContext(), TokyoGhoul3.class)); finish();}
}