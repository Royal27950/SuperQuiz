package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Manga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga);
    }
    public void goAttackOnTitan     (View v){ startActivity(new Intent(getApplicationContext(), AttackOnTitan.class));  finish();}
    public void goPokemon           (View v){ startActivity(new Intent(getApplicationContext(), Pokemon.class));        finish();}
    public void goTokyoGhoul        (View v){ startActivity(new Intent(getApplicationContext(), TokyoGhoul.class));     finish();}
    public void goMyHeroAcademia    (View v){ startActivity(new Intent(getApplicationContext(), MyHeroAcademia.class)); finish();}
    public void goOnePiece          (View v){ startActivity(new Intent(getApplicationContext(), OnePiece.class));       finish();}
}