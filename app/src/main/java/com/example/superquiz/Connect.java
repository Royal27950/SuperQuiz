package com.example.superquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Connect extends AppCompatActivity {

    EditText userID, userPassword;
    TextView textCreate, textForgetPwd;
    Button connectBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        //Allows you to keep the phone orientation in portrait mode
        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        userID = findViewById(R.id.userID);
        userPassword = findViewById(R.id.userPassword);
        connectBtn = findViewById(R.id.connectBtn);
        textCreate = findViewById(R.id.textCreate);
        textForgetPwd = findViewById(R.id.textForgetPwd);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);


        textCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Create.class));
            }
        });

        //By clicking on the "Se connecter" button, check the following conditions :
        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = userID.getText().toString().trim();
                String password = userPassword.getText().toString().trim();

                //Check if the "username" and "password" fields are empty
                if (TextUtils.isEmpty(id)){
                    userID.setError("L'identifiant est requis !");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    userPassword.setError("Le mot de passe est requis !");
                    return;
                }

                //Check that the password contains at least 6 characters
                if (password.length() < 6 ){
                    userPassword.setError("Le mot de passe doit avoir au moins 6 caractères !");
                    return;
                }

                //Make the loading bar visible (which is invisible by default)
                progressBar.setVisibility(View.VISIBLE);

                //Identifies the user
                fAuth.signInWithEmailAndPassword(id, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Connect.this, "Vous êtes connecté", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            //finish();
                        }else{
                            Toast.makeText(Connect.this, "Erreur !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        //At the click of the text "mot de passe oublié ?"
        textForgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a dialog box to see the user's email
                EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder resetPwdDialog = new AlertDialog.Builder(v.getContext());
                resetPwdDialog.setTitle("Réinitialiser votre mot de passe ?");
                resetPwdDialog.setMessage("Entrez votre mail pour reçevoir le nouveau mot de passe");
                resetPwdDialog.setView(resetMail);

                resetPwdDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the email and send an email to change the password
                        String userMail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(userMail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Connect.this, "Un lien de réinitialisation à été envoyé à cette adresse mail.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Connect.this, "Erreur le mail n'a pas été envoyé. " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                resetPwdDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Close the pop-up
                    }
                });
                resetPwdDialog.create().show();
            }
        });

    }
    //Click on the "eye" image to see or hide the password field
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

}