package iut.dam.newagapi_version311_clean.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import iut.dam.newagapi_version311_clean.R;

public class Login extends AppCompatActivity {
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginButton = findViewById(R.id.buttonConnexion);

        loginButton.setOnClickListener(v -> {
            boolean loginSuccess = true;

            if (loginSuccess) {
                SharedPreferences prefs = getSharedPreferences("Login", MODE_PRIVATE);
                prefs.edit().putBoolean("Connecter", true).apply();


                Intent intent = new Intent(this, Acceuil.class);

                startActivity(intent);
                finish();
            } else {

            }
        });



    }
}
