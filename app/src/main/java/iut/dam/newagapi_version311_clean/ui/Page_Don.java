package iut.dam.newagapi_version311_clean.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import Models.Association;
import Models.AssociationRepository;
import helpers.FooterAuthentification;
import iut.dam.newagapi_version311_clean.R;

public class Page_Don extends AppCompatActivity {

    TextView associationName, montantTotal;
    EditText editMontant;
    Button buttonValideDon, button20, button40;
    private String nomAsso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_don);

        // Initialisation des vues
        associationName = findViewById(R.id.NomAssoPageDon);
        montantTotal = findViewById(R.id.montantTotalDon);
        editMontant = findViewById(R.id.editTextNumberSigned);
        buttonValideDon = findViewById(R.id.buttonValideDon);
        button20 = findViewById(R.id.button);
        button40 = findViewById(R.id.button2);

        // Récupération nom ou ID association
        nomAsso = getIntent().getStringExtra("nom_association");
        String associationIdStr = getIntent().getStringExtra("associationId");

        if (associationIdStr != null) {
            int associationId = Integer.parseInt(associationIdStr);
            new LoadAssociationTask().execute(associationId);
        } else if (nomAsso != null) {
            associationName.setText(nomAsso);
        } else {
            associationName.setText("Aucune association sélectionnée");
        }

        // Écouteur pour boutons fixes
        button20.setOnClickListener(v -> {
            editMontant.setText("20.00");
            montantTotal.setText("20.00");
        });

        button40.setOnClickListener(v -> {
            editMontant.setText("40.00");
            montantTotal.setText("40.00");
        });

        // TextWatcher pour montant libre
        editMontant.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    montantTotal.setText(s.toString());
                } else {
                    montantTotal.setText("00.00");
                }
            }
        });

        // Validation du don
        buttonValideDon.setOnClickListener(v -> {
            String montantStr = editMontant.getText().toString().trim();
            if (montantStr.isEmpty()) {
                Toast.makeText(this, "Veuillez entrer un montant", Toast.LENGTH_SHORT).show();
                return;
            }

            double montant = Double.parseDouble(montantStr);
            SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
            int idUser = prefs.getInt("user_id", -1);

            if (idUser != -1) {
                new EnvoyerDonTask(true).execute(nomAsso, String.valueOf(montant), String.valueOf(idUser));
            } else {
                new EnvoyerDonTask(false).execute(nomAsso, String.valueOf(montant));
            }
        });

        // Bouton retour
        FooterAuthentification.retournPage(this);
    }

    private class LoadAssociationTask extends AsyncTask<Integer, Void, Association> {
        @Override
        protected Association doInBackground(Integer... indices) {
            AssociationRepository repo = new AssociationRepository();
            List<Association> associations = repo.getAssociationsFromApi();
            if (associations != null && !associations.isEmpty()) {
                int index = indices[0] - 1;
                if (index >= 0 && index < associations.size()) {
                    return associations.get(index);
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Association association) {
            if (association != null) {
                nomAsso = association.getNom_association();
                associationName.setText(nomAsso);
            } else {
                associationName.setText("Association introuvable");
            }
        }
    }

    private class EnvoyerDonTask extends AsyncTask<String, Void, String> {
        private final boolean isUserConnecte;

        public EnvoyerDonTask(boolean isUserConnecte) {
            this.isUserConnecte = isUserConnecte;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                String nom_asso = params[0];
                String montant = params[1];

                String urlStr = isUserConnecte
                        ? "https://ychnightder.alwaysdata.net/Don.php"
                        : "https://ychnightder.alwaysdata.net/DonAnonyme.php";

                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json; utf-8");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("nom_association", nom_asso);
                jsonParam.put("montant", montant);
                if (isUserConnecte) {
                    String id_user = params[2];
                    jsonParam.put("id_user", id_user);
                }

                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonParam.toString().getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    sb.append(line.trim());
                }

                return sb.toString();

            } catch (Exception e) {
                e.printStackTrace();
                return "{\"success\":false,\"message\":\"Erreur réseau: " + e.getMessage() + "\"}";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            new AlertDialog.Builder(Page_Don.this)
                    .setTitle("Don")
                    .setMessage("Réponse" + result)
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
