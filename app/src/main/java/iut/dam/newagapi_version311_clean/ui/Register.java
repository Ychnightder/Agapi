package iut.dam.newagapi_version311_clean.ui;

import helpers.FooterAuthentification;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import static helpers.Authentification.inscription;
import static helpers.FooterAuthentification.retournPage;
import androidx.appcompat.app.AppCompatActivity;
import iut.dam.newagapi_version311_clean.R;

public class Register extends AppCompatActivity {
    EditText editTextMail, editTextMDP, editTextTel;
    Button buttonInscription, buttonTitleConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
        FooterAuthentification.retournPage(this);
        editTextMail = findViewById(R.id.editTextTextEmailAddress);
        editTextMDP = findViewById(R.id.editTextMdp);
        editTextTel = findViewById(R.id.editTextTel);
        buttonInscription = findViewById(R.id.buttonInscription);
        buttonTitleConnection = findViewById(R.id.titlebuttonConnexion);

        buttonInscription.setOnClickListener(v -> {
            inscription(editTextMail,editTextMDP,editTextTel,this);
        });
        buttonTitleConnection.setOnClickListener(v -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        });
        retournPage(this);
    }
}
