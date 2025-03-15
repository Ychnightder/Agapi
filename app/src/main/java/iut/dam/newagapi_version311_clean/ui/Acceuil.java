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
import iut.dam.newagapi_version311_clean.R;

public class Acceuil extends AppCompatActivity {

    //partie test
    int[] ImageAssociation = {
            R.drawable.profil,R.drawable.profil,
            R.drawable.profil,R.drawable.profil,
            R.drawable.profil,R.drawable.profil
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil);

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

        setrecycleviews();

    }
    @Override
    protected void onResume() {
        stub = findViewById(R.id.login_buttons_stub);
        rootLayout = findViewById(R.id.main);
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        boolean connecter = preferences.getBoolean("Connecter", false);


        if (connecter && stub.getParent() != null) {
            View inflatedView = stub.inflate();
            buttonPourvous = inflatedView.findViewById(R.id.buttonPourVous);
            buttonSuivies = inflatedView.findViewById(R.id.buttonSuivies);
            viewPourvous =  inflatedView.findViewById(R.id.barButton_Pourvous);
            viewSuivies = inflatedView.findViewById(R.id.barButton_Suivis);
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


         buttonProfil = findViewById(R.id.buttonProfil);
         buttonAcceuil = findViewById(R.id.buttonAcceuil);
         buttonAsso = findViewById(R.id.buttonAsso);
         textViewProfil = findViewById(R.id.textViewProfil);
         textViewAsso = findViewById(R.id.textViewAssociations);
         textViewAcceuil = findViewById(R.id.textViewAccueil);




        View.OnClickListener buttonClickListener = v -> {
            textViewProfil.setTextColor(Color.WHITE);
            textViewAsso.setTextColor(Color.WHITE);
            textViewAcceuil.setTextColor(Color.WHITE);

            buttonProfil.setImageResource(R.drawable.profil);
            buttonAcceuil.setImageResource(R.drawable.home);
            buttonAsso.setImageResource(R.drawable.charity);
            if (v.getId() == R.id.buttonProfil) {
                changeCouleurOnclick(textViewProfil, buttonProfil);
            } else if (v.getId() == R.id.buttonAcceuil) {
                changeCouleurOnclick(textViewAcceuil, buttonAcceuil);
            } else if (v.getId() == R.id.buttonAsso) {
                changeCouleurOnclick(textViewAsso, buttonAsso);
            } else if (v.getId() == R.id.buttonPourVous) {
                viewSuivies.setVisibility(View.GONE);
                viewPourvous.setVisibility(View.VISIBLE);
            } else if (v.getId() == R.id.buttonSuivies) {
                viewSuivies.setVisibility(View.VISIBLE);
                viewPourvous.setVisibility(View.GONE);
            }
        };

        buttonProfil.setOnClickListener(buttonClickListener);
        buttonAcceuil.setOnClickListener(buttonClickListener);
        buttonAsso.setOnClickListener(buttonClickListener);

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

    private void changeCouleurOnclick(TextView textView, ImageButton imageButton) {
        int couleurOnclick = Color.parseColor("#F2409D");

        textView.setTextColor(couleurOnclick);

        if (imageButton.getId() == R.id.buttonProfil) {
            imageButton.setImageResource(R.drawable.bottomnav_profilonclick);
        } else if (imageButton.getId() == R.id.buttonAcceuil) {
            imageButton.setImageResource(R.drawable.bottomnav_homeonclick);
        } else if (imageButton.getId() == R.id.buttonAsso) {
            imageButton.setImageResource(R.drawable.bottomnav_charityonclick);
        }
    }

}
