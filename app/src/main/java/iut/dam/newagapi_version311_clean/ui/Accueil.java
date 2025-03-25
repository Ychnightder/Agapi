package iut.dam.newagapi_version311_clean.ui;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Models.ModeleHorizontalscrollview;
import Models.ModeleVerticalscrollview;
import adapteurs.AdapteurHorizontal;
import adapteurs.AdapteurVertical;
import helpers.BottomNavControler;
import iut.dam.newagapi_version311_clean.R;

public class Accueil extends AppCompatActivity {

    //partie test
    int[] ImageAssociation = {
            R.drawable.charity,R.drawable.charity,
            R.drawable.charity,R.drawable.charity,
            R.drawable.charity,R.drawable.charity,
    };
    //fin de la partie test
    ArrayList<ModeleHorizontalscrollview> modeleHorizontalscrollviews = new ArrayList<>();
    ArrayList<ModeleVerticalscrollview> modeleverticalscrollviews = new ArrayList<>();
    RecyclerView recyclerViewHorizontal, recyclerViewVertical;
    AdapteurHorizontal adapteurHorizontal;
    AdapteurVertical adapteurVertical;
    ViewStub stub;
    ConstraintLayout rootLayout;
    ImageButton buttonProfil, buttonAcceuil, buttonAsso;
    TextView textViewProfil, textViewAsso, textViewAcceuil;
    Button buttonPourvous, buttonSuivies;
    View viewPourvous, viewSuivies;

    private final int couleurOnclick = Color.parseColor("#F2409D");
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);

        recyclerViewHorizontal = findViewById(R.id.recyclerViewHorizontal);
        recyclerViewVertical = findViewById(R.id.recyclerViewVertical);

        adapteurHorizontal = new AdapteurHorizontal(this, modeleHorizontalscrollviews);
        adapteurVertical = new AdapteurVertical(this, modeleverticalscrollviews);

        recyclerViewVertical.setAdapter(adapteurVertical);
        recyclerViewHorizontal.setAdapter(adapteurHorizontal);

        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerViewHorizontal.setNestedScrollingEnabled(false);
        recyclerViewVertical.setNestedScrollingEnabled(false);

        BottomNavControler.setupNavigation(this,R.id.buttonAccueil);
        buttonAcceuil = findViewById(R.id.buttonAccueil);
        textViewAcceuil = findViewById(R.id.textViewAccueil);
        buttonAcceuil.setImageResource(R.drawable.bottomnav_homeonclick);
        textViewAcceuil.setTextColor(couleurOnclick);

        setrecycleviews();
        preferences = getSharedPreferences("Login", MODE_PRIVATE);
        preferences.edit().clear().apply();



    }
    @Override
    protected void onResume() {
        super.onResume();
        boolean connecter = preferences.getBoolean("Connecter", false);


        View loginButtonsContainer = findViewById(R.id.login_buttons_container);
        rootLayout = findViewById(R.id.main);

        if (connecter) {

            loginButtonsContainer.setVisibility(View.VISIBLE);

            buttonPourvous = findViewById(R.id.buttonPourVous);
            buttonSuivies = findViewById(R.id.buttonSuivies);
            viewPourvous = findViewById(R.id.barButton_Pourvous);
            viewSuivies = findViewById(R.id.barButton_Suivis);

            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(rootLayout);
            constraintSet.connect(
                    R.id.section_association,
                    ConstraintSet.TOP,
                    R.id.buttonText,
                    ConstraintSet.BOTTOM
            );
            constraintSet.applyTo(rootLayout);

            buttonPourvous.setOnClickListener(v -> {
                viewPourvous.setVisibility(View.VISIBLE);
                viewSuivies.setVisibility(View.GONE);
            });

            buttonSuivies.setOnClickListener(v -> {
                viewPourvous.setVisibility(View.GONE);
                viewSuivies.setVisibility(View.VISIBLE);
            });

        }
//        else if (deconnecter){
//            loginButtonsContainer.setVisibility(View.GONE);
//
//            ConstraintSet constraintSet = new ConstraintSet();
//            constraintSet.clone(rootLayout);
//            constraintSet.connect(
//                    R.id.section_association,
//                    ConstraintSet.TOP,
//                    R.id.header,
//                    ConstraintSet.BOTTOM
//            );
//            constraintSet.applyTo(rootLayout);
//        }
//  methode future pour deconnecter



        View.OnClickListener buttonClickListener = v -> {
            if (v.getId() == R.id.buttonPourVous) {
                viewSuivies.setVisibility(View.GONE);
                viewPourvous.setVisibility(View.VISIBLE);
            } else if (v.getId() == R.id.buttonSuivies) {
                viewSuivies.setVisibility(View.VISIBLE);
                viewPourvous.setVisibility(View.GONE);
            }
        };



    }
    private void setrecycleviews() {
        String[] ListeAsso = getResources().getStringArray(R.array.nom_association);
        String[] DescriptionAsso = getResources().getStringArray(R.array.Description_association);
        for (int i = 0; i < ListeAsso.length; i++) {
            modeleHorizontalscrollviews.add(
                    new ModeleHorizontalscrollview( ImageAssociation[i] , ListeAsso[i])
            );
            modeleverticalscrollviews.add(
                    new ModeleVerticalscrollview(ListeAsso[i], ImageAssociation[i], DescriptionAsso[i], ImageAssociation[i] ));
        }
    }

}
