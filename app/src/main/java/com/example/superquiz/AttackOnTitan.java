package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AttackOnTitan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack_on_titan);
    }
    public void goQ2(View v){ startActivity(new Intent(getApplicationContext(), AttackOnTitan2.class));finish(); }
}