package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AttackOnTitan3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack_on_titan3);
    }
    public void goQ4(View v){ startActivity(new Intent(getApplicationContext(), AttackOnTitan4.class)); finish();}
}