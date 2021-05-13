package com.example.superquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Create extends AppCompatActivity {

    EditText userID, userPassword;
    Button createButton;
    TextView loginText;
    FirebaseAuth fAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        userID          = findViewById(R.id.userID);
        userPassword    = findViewById(R.id.userPassword);
        createButton    = findViewById(R.id.createButton);
        loginText       = findViewById(R.id.loginText);
        progressBar = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();

        //Vérifie si l'utilisateur possède déjà un compte
        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        //Au clique du bouton "Créer", vérifie les conditions suivantes :
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = userID.getText().toString().trim();
                String password = userPassword.getText().toString().trim();

                //Vérifie si les chammps "identifiant" et "mot de passe" sont vides
                if (TextUtils.isEmpty(id)){
                    userID.setError("L'identifiant est requis !");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    userPassword.setError("Le mot de passe est requis !");
                    return;
                }

                //Vérifie que le mot de passe contient au minimum 6 caractères
                if (password.length() < 6 ){
                    userPassword.setError("Le mot de passe doit avoir au moins 6 caractères !");
                    return;
                }

                //Rend la bar de chargement visible (qui est invisible par défaut)
                progressBar.setVisibility(View.VISIBLE);

                //Créer le compte dans Firebase
                fAuth.createUserWithEmailAndPassword(id, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Create.this, "Compte créé", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else{
                            Toast.makeText(Create.this, "Erreur !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

    }

    //Au clique de l'image "oeil" permet de voir ou de cacher le champ mot de passe
    public void showHidePass(View view){

        if(view.getId()==R.id.show_pass_btn){

            if(userPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.hide_password);

                //Show Password
                userPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.show_password);

                //Hide Password
                userPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        }
    }

    //Au clique du bouton "Déconnexion" déconnecte l'utilisateur et le renvoie à la page de connexion
    public void connect(View v){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Connect.class));
        finish();
    }
}