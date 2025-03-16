package iut.dam.agapi.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import iut.dam.agapi.R;
import iut.dam.agapi.managers.AppDatabase;
import iut.dam.agapi.managers.DAO.UtilisateurDao;
import iut.dam.agapi.managers.models.Utilisateur;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, motDePasseEditText;
    private AppDatabase db;
    private ExecutorService executorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.login_email);
        motDePasseEditText = findViewById(R.id.login_mot_de_passe);
        Button loginButton = findViewById(R.id.btn_login);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app-database").build();
        executorService = Executors.newSingleThreadExecutor();


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = emailEditText.getText().toString();
        String motDePasse = motDePasseEditText.getText().toString();

        if (email.isEmpty() || motDePasse.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Utilisateur utilisateur1 = new Utilisateur();
                utilisateur1.nom = "Doe";
                utilisateur1.prenom = "John";
                utilisateur1.email = "john.doe@example.com";
                utilisateur1.mot_de_passe = "password";
                utilisateur1.date_inscription = 1;
                db.utilisateurDao().insert(utilisateur1);

                Utilisateur utilisateur = db.utilisateurDao().getUtilisateurByEmail(email);

                if (utilisateur != null && utilisateur.mot_de_passe.equals(motDePasse)) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                            // Naviguer vers une autre activité ou effectuer une action après la connexion
                        }
                    });
                } else {
                    runOnUiThread(() -> Toast.makeText(LoginActivity.this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show());
                }
            }
        });
    }
}