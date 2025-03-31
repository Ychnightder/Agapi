package iut.dam.newagapi_version311_clean.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Models.Association;
import Models.AssociationRepository;
import adapteurs.AdapteurGalerie;
import helpers.FooterAuthentification;
import iut.dam.newagapi_version311_clean.R;

public class Page_association extends AppCompatActivity {

    Button buttonDon;
    TextView nomAsso, description;
    private String nomAssociation;
    RecyclerView galerieRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_association);

        String nomAssoRecu = getIntent().getStringExtra("nom_association");

        nomAsso = findViewById(R.id.NomAssociation);
        description = findViewById(R.id.Description);
        galerieRecyclerView = findViewById(R.id.imagesGalerie);
        buttonDon = findViewById(R.id.buttonDon);

        new Thread(() -> {
            AssociationRepository repo = new AssociationRepository();
            Association asso = repo.getAssociationByNom(nomAssoRecu);

            runOnUiThread(() -> {
                if (asso == null) {
                    Log.e("DEBUG", "Association non trouvée avec nom = " + nomAssoRecu);
                    finish();
                    return;
                }
                nomAssociation = asso.getNom_association();
                nomAsso.setText(nomAssociation);
                description.setText(asso.getDescription());

                List<String> imageUrls = asso.getImagePresentation();
                galerieRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                galerieRecyclerView.setAdapter(new AdapteurGalerie(this, imageUrls));
            });
        }).start();

        buttonDon.setOnClickListener(v -> {
            Intent intent = new Intent(this, Page_Don.class);
            intent.putExtra("nom_association", nomAssociation);
            startActivity(intent);
        });

        FooterAuthentification.retournPage(this);
    }
}
