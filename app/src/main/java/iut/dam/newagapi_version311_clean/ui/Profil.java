package iut.dam.newagapi_version311_clean.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import fragments.InscriptionFragment;
import fragments.LoginFragment;
import fragments.UserFragment;
import helpers.BottomNavControler;
import helpers.FooterAuthentification;
import iut.dam.newagapi_version311_clean.R;

public class Profil extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_profil);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer_page_profil, new UserFragment())
                .commit();

        BottomNavControler.setupNavigation(this);


    }
}
