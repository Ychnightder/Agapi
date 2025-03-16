package iut.dam.agapi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.IOException;
import java.util.regex.Pattern;
import iut.dam.agapi.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity2 extends AppCompatActivity {

    private EditText nomEditText, prenomEditText, emailEditText, motDePasseEditText;
    private OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        nomEditText = findViewById(R.id.register_nom);
        prenomEditText = findViewById(R.id.register_prenom);
        emailEditText = findViewById(R.id.register_email);
        motDePasseEditText = findViewById(R.id.register_mot_de_passe);
        Button registerButton = findViewById(R.id.btn_register);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    registerUser();
                }
            }
        });

    }
    private void registerUser() {
        String nom = nomEditText.getText().toString();
        String prenom = prenomEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String motDePasse = motDePasseEditText.getText().toString();


        RequestBody formBody = new FormBody.Builder()
                .add("nom", nom)
                .add("prenom", prenom)
                .add("email", email)
                .add("mot_de_passe", motDePasse)
                .build();

        Request request = new Request.Builder()
                .url("https://ychnightder.alwaysdata.net/register.php") // Remplacez par l'URL de votre script PHP
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RegisterActivity2.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    Log.d("Response", responseData);
                    try {
                        JSONObject jsonObject = new JSONObject(responseData);
                        boolean success = jsonObject.getBoolean("success");
                        String message = jsonObject.getString("message");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity2.this, message, Toast.LENGTH_SHORT).show();
                                if (success) {
                                    Intent intent = new Intent(RegisterActivity2.this, LoginActivity2.class);
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
            Toast.makeText(RegisterActivity2.this, "L'email ne peut pas être vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification de l'email
        if (!isValidEmail(email)) {
            Toast.makeText(RegisterActivity2.this, "Email invalide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification si le mot de passe est vide
        if (motDePasse.isEmpty()) {
            Toast.makeText(RegisterActivity2.this, "Le mot de passe ne peut pas être vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification du mot de passe
        if (!isValidPassword(motDePasse)) {
            Toast.makeText(RegisterActivity2.this, "Le mot de passe doit contenir au moins un chiffre, une lettre majuscule, une lettre minuscule, un caractère spécial, et faire au moins 8 caractères", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValidPassword(String password) {
        Pattern PASSWORD_PATTERN =
                Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}