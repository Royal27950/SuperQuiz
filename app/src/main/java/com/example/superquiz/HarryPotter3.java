package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HarryPotter3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harry_potter3);
    }
    public void goQ4(View v){ startActivity(new Intent(getApplicationContext(), HarryPotter4.class));finish(); }
}