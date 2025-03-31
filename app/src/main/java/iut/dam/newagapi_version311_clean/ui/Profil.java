package iut.dam.newagapi_version311_clean.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fragments.InscriptionFragment;
import fragments.LoginFragment;
import fragments.UserFragment;
import helpers.BottomNavControler;
import helpers.FooterAuthentification;
import iut.dam.newagapi_version311_clean.R;


public class Profil extends AppCompatActivity {
    private final int couleureOnclick = Color.parseColor("#F2409D");
    ImageButton buttonProfil;
    TextView textViewProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_profil);
        buttonProfil = findViewById(R.id.buttonProfil);
        textViewProfil = findViewById(R.id.textViewProfil);
        textViewProfil.setTextColor(couleureOnclick);
        buttonProfil.setImageResource(R.drawable.bottomnav_profilonclick);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer_page_profil, new UserFragment())
                .commit();

        BottomNavControler.setupNavigation(this);


    }
}
