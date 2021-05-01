package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logout(View v){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Connect.class));
        finish();
    }
    public void goGeneralCulture(View v){ startActivity(new Intent(getApplicationContext(), GeneralCulture.class)); }
    public void goManga(View v){ startActivity(new Intent(getApplicationContext(), Manga.class)); }
    public void goBrand(View v){
        startActivity(new Intent(getApplicationContext(), Brand.class));
    }
    public void goSeries(View v){ startActivity(new Intent(getApplicationContext(), Series.class));}
    public void goMovies(View v){ startActivity(new Intent(getApplicationContext(), Movies.class)); }
    public void goRanking(View v){ startActivity(new Intent(getApplicationContext(), Ranking.class)); }
}