package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.ConfigurationCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class Ranking extends AppCompatActivity {

    TextView country;
    Locale locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        country = findViewById(R.id.country);
        locale = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);

        country.setText(locale.getDisplayCountry());
    }
    public void goBack(View v){ startActivity(new Intent(getApplicationContext(), MainActivity.class)); finish();}
}