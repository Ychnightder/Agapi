package iut.dam.agapi.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import iut.dam.agapi.adapter.Adapteur;
import iut.dam.agapi.adapter.AdapteurDescriptionAsso;
import iut.dam.agapi.models.ModeleDescriptionAssociation;
import iut.dam.agapi.models.ModeleHorizontalscrollview;
import iut.dam.agapi.R;

public class MainActivity extends AppCompatActivity {
    ArrayList<ModeleHorizontalscrollview> modeleHorizontalscrollviews = new ArrayList<>();

    ArrayList<ModeleDescriptionAssociation> modeleDescriptionAssociations = new ArrayList<>();
    int[] ImageAssociation = {
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewHorizontal = findViewById(R.id.recyclerView);
        RecyclerView recyclerViewVertical = findViewById(R.id.recyclerViewDescription);

        setModeleHorizontalscrollviews();
        Adapteur adapteur = new Adapteur(this, modeleHorizontalscrollviews);
        recyclerViewHorizontal.setAdapter(adapteur);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHorizontal.setNestedScrollingEnabled(false);

        AdapteurDescriptionAsso adapteurDescriptionAsso = new AdapteurDescriptionAsso(this, modeleDescriptionAssociations);
        recyclerViewVertical.setAdapter(adapteurDescriptionAsso);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewHorizontal.setNestedScrollingEnabled(false);

        ImageButton buttonProfil = findViewById(R.id.buttonProfil);
        ImageButton buttonAcceuil = findViewById(R.id.buttonAcceuil);
        ImageButton buttonAsso = findViewById(R.id.buttonAsso);
        TextView textViewProfil = findViewById(R.id.textViewProfil);
        TextView textViewAsso = findViewById(R.id.textViewAssociations);
        TextView textViewAcceuil = findViewById(R.id.textViewAccueil);


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
            }
        };

        buttonProfil.setOnClickListener(buttonClickListener);
        buttonAcceuil.setOnClickListener(buttonClickListener);
        buttonAsso.setOnClickListener(buttonClickListener);

    }

    private void changeCouleurOnclick(TextView textView, ImageButton imageButton) {
        int couleurOnclick = Color.parseColor("#F2409D");
        int couleurNormal = Color.WHITE;


        textView.setTextColor(couleurOnclick);

        if (imageButton.getId() == R.id.buttonProfil) {
            imageButton.setImageResource(R.drawable.profilonclick);
        } else if (imageButton.getId() == R.id.buttonAcceuil) {
            imageButton.setImageResource(R.drawable.homeonclick);
        } else if (imageButton.getId() == R.id.buttonAsso) {
            imageButton.setImageResource(R.drawable.charityonclick);
        }
    }

    private void setModeleHorizontalscrollviews() {
        String[] ListeAsso = getResources().getStringArray(R.array.nom_association);
        String[] DescriptionAsso = getResources().getStringArray(R.array.Description_association);
        for (int i = 0; i < ListeAsso.length; i++) {
            modeleHorizontalscrollviews.add(
                    new ModeleHorizontalscrollview( ImageAssociation[i] , ListeAsso[i])
            );
            modeleDescriptionAssociations.add(new ModeleDescriptionAssociation(ListeAsso[i], ImageAssociation[i], DescriptionAsso[i], ImageAssociation[i] ));
        }
    }
}