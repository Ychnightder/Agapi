package iut.dam.newagapi_version311_clean.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import fragments.AdminFragmentAssociation;
import fragments.UserFragment;
import helpers.BottomNavControler;
import iut.dam.newagapi_version311_clean.R;

public class Profil_Admin extends AppCompatActivity {

    ConstraintLayout tabProfil, tabAssociation;

    View underlineProfil, underlineAssociation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_profil_admin);
        tabProfil = findViewById(R.id.tab_profil);
        tabAssociation = findViewById(R.id.tab_association);
        underlineProfil = findViewById(R.id.underline_profil);
        underlineAssociation = findViewById(R.id.underline_association);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer_page_profil_admin, new UserFragment())
                .commit();

        BottomNavControler.setupNavigation(this);

        tabProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                underlineProfil.setVisibility(View.VISIBLE);
                underlineAssociation.setVisibility(View.INVISIBLE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer_page_profil_admin, new UserFragment())
                        .commit();

            }
        });

        tabAssociation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                underlineProfil.setVisibility(View.INVISIBLE);
                underlineAssociation.setVisibility(View.VISIBLE);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer_page_profil_admin, new AdminFragmentAssociation())
                        .commit();
            }
        });
    }








}
