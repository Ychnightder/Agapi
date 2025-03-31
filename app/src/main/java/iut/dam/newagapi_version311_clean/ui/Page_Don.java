package iut.dam.newagapi_version311_clean.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import Models.Association;
import Models.AssociationRepository;
import helpers.BottomNavControler;
import iut.dam.newagapi_version311_clean.R;

public class Page_Don extends AppCompatActivity {

    private TextView associationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_don);
        BottomNavControler.setupNavigation(this);

        associationName = findViewById(R.id.NomAssoPageDon);

        Intent intent = getIntent();
        String associationIdStr = intent.getStringExtra("associationId");

        if (associationIdStr != null) {
            int associationId = Integer.parseInt(associationIdStr);
            new LoadAssociationTask().execute(associationId);
        } else {
            associationName.setText("Aucune association sélectionnée");
        }
    }

    private class LoadAssociationTask extends AsyncTask<Integer, Void, Association> {
        @Override
        protected Association doInBackground(Integer... ids) {
            AssociationRepository repo = new AssociationRepository();
            List<Association> associations = repo.getAssociationsFromApi();
            if (associations != null) {
                for (Association asso : associations) {
                    if (asso.getId_association() == ids[0]) {
                        return asso;
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Association association) {
            if (association != null) {
                associationName.setText(association.getNom_association());
            } else {
                associationName.setText("Association introuvable");
            }
        }
    }
}
