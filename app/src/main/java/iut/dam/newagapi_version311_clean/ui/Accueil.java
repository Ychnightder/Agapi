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

import java.util.ArrayList;
import java.util.List;

import Models.Association;
import Models.AssociationRepository;
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

        BottomNavControler.setupNavigation(this);
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
        ViewGroup loginButtonsContainer = findViewById(R.id.view3);
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
        new Thread(() -> {
            AssociationRepository repository = new AssociationRepository();
            List<Association> associations = repository.getAssociationsFromApi();

            // 清空旧数据，防止叠加或残留
            modeleHorizontalscrollviews.clear();
            modeleverticalscrollviews.clear();

            if (associations != null) {
                int index = 0;
                for (Association association : associations) {
                    index++;

                    //Passer des donnes au recycleview horizontal
                    modeleHorizontalscrollviews.add(
                            new ModeleHorizontalscrollview(
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
                            new ModeleVerticalscrollview(
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
                    Log.d("ASSO_SIZE", "Horizontal count: " + modeleHorizontalscrollviews.size());
                    Log.d("ASSO_SIZE", "Vertical count: " + modeleverticalscrollviews.size());

                    adapteurHorizontal.notifyDataSetChanged();
                    adapteurVertical.notifyDataSetChanged();
                });
            } else {
                Log.e("ASSO_FETCH", "Association list is null.");
            }
        }).start();
    }





}
