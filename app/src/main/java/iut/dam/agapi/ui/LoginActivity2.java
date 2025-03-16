package iut.dam.agapi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import iut.dam.agapi.R;
import iut.dam.agapi.managers.AppDatabase;
import iut.dam.agapi.managers.models.Utilisateur;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity2 extends AppCompatActivity {

    private EditText emailEditText, motDePasseEditText;
    private OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        emailEditText = findViewById(R.id.login_email);
        motDePasseEditText = findViewById(R.id.login_mot_de_passe);
        Button loginButton = findViewById(R.id.btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    loginUser();
                }
            }
        });

    }

    private void loginUser() {
        String email = emailEditText.getText().toString();
        String motDePasse = motDePasseEditText.getText().toString();

        // Construire la requête pour se connecter
        RequestBody formBody = new FormBody.Builder()
                .add("email", email)
                .add("mot_de_passe", motDePasse)
                .build();

        Request request = new Request.Builder()
                .url("https://ychnightder.alwaysdata.net/login.php") // Remplacez par l'URL de votre script PHP
                .post(formBody)
                .build();

        // Effectuer la requête de manière asynchrone
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity2.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(responseData);
                        boolean success = jsonObject.getBoolean("success");
                        String message = jsonObject.getString("message");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity2.this, message, Toast.LENGTH_SHORT).show();
                                if (success) {
                                    // Rediriger vers l'écran principal ou l'écran d'accueil
                                    Intent intent = new Intent(LoginActivity2.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private boolean validateInputs() {
        String email = emailEditText.getText().toString().trim();
        String motDePasse = motDePasseEditText.getText().toString().trim();

        // Vérification si l'email est vide
        if (email.isEmpty()) {
            Toast.makeText(LoginActivity2.this, "L'email ne peut pas être vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification de l'email
        if (!isValidEmail(email)) {
            Toast.makeText(LoginActivity2.this, "Email invalide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification si le mot de passe est vide
        if (motDePasse.isEmpty()) {
            Toast.makeText(LoginActivity2.this, "Le mot de passe ne peut pas être vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}