package iut.dam.newagapi_version311_clean.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Models.ModeleHorizontalscrollview;
import Models.ModeleVerticalscrollview;
import adapteurs.AdapteurHorizontal;
import adapteurs.AdapteurVertical;
import iut.dam.newagapi_version311_clean.R;

public class Acceuil extends AppCompatActivity {

    int[] ImageAssociation = {
            R.drawable.profil,R.drawable.profil,
            R.drawable.profil,R.drawable.profil,
            R.drawable.profil,R.drawable.profil
    };
    ArrayList<ModeleHorizontalscrollview> modeleHorizontalscrollviews = new ArrayList<>();
    ArrayList<ModeleVerticalscrollview> modeleverticalscrollviews = new ArrayList<>();
    RecyclerView recyclerViewHorizontal, recyclerViewVertical;
    AdapteurHorizontal adapteurHorizontal;
    AdapteurVertical adapteurVertical;

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
