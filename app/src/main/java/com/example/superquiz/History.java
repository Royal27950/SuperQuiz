package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class History extends AppCompatActivity {

    Button reponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        reponse = findViewById(R.id.r1);


    }

    public void goQ2(View v){
        reponse.setBackgroundColor(getResources().getColor(R.color.wrong));
        startActivity(new Intent(getApplicationContext(), History2.class));
        finish();
    }
}
