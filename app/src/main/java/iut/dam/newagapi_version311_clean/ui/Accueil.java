package iut.dam.newagapi_version311_clean.ui;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import Models.Association;
import Models.AssociationRepository;
import adapteurs.AdapteurHorizontal;
import adapteurs.AdapteurVertical;
import fragments.AccueilFragment2Button;
import helpers.BottomNavControler;
import iut.dam.newagapi_version311_clean.R;

public class Accueil extends AppCompatActivity {

    ArrayList<Association> modeleHorizontalscrollviews = new ArrayList<>();
    ArrayList<Association> modeleverticalscrollviews = new ArrayList<>();
    RecyclerView recyclerViewHorizontal, recyclerViewVertical;
    AdapteurHorizontal adapteurHorizontal;
    AdapteurVertical adapteurVertical;
    ViewStub stub;
    ConstraintLayout rootLayout;
    ImageButton buttonProfil, buttonAcceuil;
    TextView textViewAcceuil;
    Button buttonPourvous, buttonSuivies;
    View viewPourvous, viewSuivies;

    private final int couleurOnclick = Color.parseColor("#F2409D");
    SharedPreferences preferences,donnesAsso;
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

        BottomNavControler.setupNavigation(this);
        buttonAcceuil = findViewById(R.id.buttonAccueil);
        textViewAcceuil = findViewById(R.id.textViewAccueil);
        buttonAcceuil.setImageResource(R.drawable.bottomnav_homeonclick);
        textViewAcceuil.setTextColor(couleurOnclick);

        setrecycleviews();
        SharedPreferences.Editor editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
        editor.clear();
        editor.putBoolean("Login", true);
        editor.apply();


    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        boolean connecter = preferences.getBoolean("Login", false);
        Log.d("DEBUG booealn", "Connecter vaut: " + connecter);

        ViewGroup loginButtonsContainer = findViewById(R.id.view3);
        rootLayout = findViewById(R.id.main);

        if (connecter) {
            loginButtonsContainer.setVisibility(View.VISIBLE);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.view3, new AccueilFragment2Button())
                    .commit();
        }
    }
    private void setrecycleviews() {
        new Thread(() -> {
            AssociationRepository repository = new AssociationRepository();
            List<Association> associations = repository.getAssociationsFromApi();

            modeleHorizontalscrollviews.clear();
            modeleverticalscrollviews.clear();

            if (associations != null) {
                int index = 0;
                for (Association association : associations) {
                    index++;

                    //Passer des donnes au recycleview horizontal
                    modeleHorizontalscrollviews.add(
                            new Association(
                                    association.getLogo(),
                                    association.getNom_association()
                            )
                    );

                    //recupere premier image(URL) dans la base de donne
                    String firstImage = null;
                    List<String> imageList = association.getImagePresentation();
                    if (imageList != null && !imageList.isEmpty()) {
                        firstImage = imageList.get(0).trim();
                    }

                    Log.d("ASSO_DATA", "Vertical #" + index + " - " + association.getNom_association());
                    Log.d("ASSO_DATA", "Logo: " + association.getLogo());
                    Log.d("ASSO_DATA", "Image: " + firstImage);

                    //Passer des donnes au recycleview vertical
                    modeleverticalscrollviews.add(
                            new Association(
                                    association.getNom_association(),
                                    association.getLogo(),
                                    association.getDescription(),
                                    firstImage
                            )
                    );
                }

                // Actualiser les views
                //les log.d c pour tester on peut enlever a la fin
                runOnUiThread(() -> {

                    adapteurHorizontal.notifyDataSetChanged();
                    adapteurVertical.notifyDataSetChanged();
                    Gson gson = new Gson();
                    String jsonListHorizontal = gson.toJson(modeleHorizontalscrollviews);

                    SharedPreferences sharedPreferences = getSharedPreferences("ASSO_DATA", MODE_PRIVATE);
                    sharedPreferences.edit().putString("HorizontalList", jsonListHorizontal).apply();
                    String jsonListVertical = gson.toJson(modeleverticalscrollviews);
                    SharedPreferences sharedPreferencesList = getSharedPreferences("ASSO_DATAList", MODE_PRIVATE);
                    sharedPreferencesList.edit().putString("VerticalList", jsonListVertical).apply();

                });
            } else {
                Log.e("ASSO_FETCH", "Association list is null.");
            }
        }).start();
    }





}
