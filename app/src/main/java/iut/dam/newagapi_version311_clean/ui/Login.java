package iut.dam.newagapi_version311_clean.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import helpers.FooterAuthentification;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import iut.dam.newagapi_version311_clean.R;

public class Login extends AppCompatActivity {
    private Button loginButton,buttonInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginButton = findViewById(R.id.buttonConnection);
        buttonInscription = findViewById(R.id.titleInscription);

        loginButton.setOnClickListener(v -> {
            boolean loginSuccess = true;
            if (loginSuccess) {
                SharedPreferences prefs = getSharedPreferences("Login", MODE_PRIVATE);
                prefs.edit().putBoolean("Connecter", true).apply();
                finish();
            } else {
                //methode mot de passe erreur
            }
        });
        FooterAuthentification.retournPage(this);
        buttonInscription.setOnClickListener(v -> {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        });

    }
}
