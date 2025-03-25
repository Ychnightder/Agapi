package iut.dam.newagapi_version311_clean.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import fragments.InscriptionFragment;
import fragments.LoginFragment;
import helpers.FooterAuthentification;
import iut.dam.newagapi_version311_clean.R;
import helpers.BottomNavControler;


public class Login_Inscription extends AppCompatActivity {

    Button buttonInscription, buttonConnection;
    View viewLeft, viewRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_inscription);

        buttonInscription = findViewById(R.id.titleInscription);
        buttonConnection = findViewById(R.id.titlebuttonConnexion);

        viewLeft = findViewById(R.id.viewLeft);
        viewRight = findViewById(R.id.viewRight);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer, new LoginFragment())
                .commit();

        FooterAuthentification.retournPage(this);

        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewLeft.setVisibility(View.INVISIBLE);
                viewRight.setVisibility(View.VISIBLE);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, new InscriptionFragment())
                        .commit();
            }
        });

        buttonConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewLeft.setVisibility(View.VISIBLE);
                viewRight.setVisibility(View.INVISIBLE);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, new LoginFragment())
                        .commit();
            }
        });

    }


}
