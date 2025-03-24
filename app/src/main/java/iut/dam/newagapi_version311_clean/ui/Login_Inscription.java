package iut.dam.newagapi_version311_clean.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import fragments.InscriptionFragment;
import fragments.LoginFragment;
import iut.dam.newagapi_version311_clean.R;

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

        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewLeft.setVisibility(View.INVISIBLE);
                viewRight.setVisibility(View.VISIBLE);

                buttonInscription.setTextColor(getResources().getColor(R.color.black));
                buttonConnection.setTextColor(getResources().getColor(R.color.white));



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

                buttonInscription.setTextColor(getResources().getColor(R.color.white));
                buttonConnection.setTextColor(getResources().getColor(R.color.black));

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, new LoginFragment())
                        .commit();
            }
        });

    }
}