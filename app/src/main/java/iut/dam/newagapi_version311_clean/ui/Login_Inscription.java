package iut.dam.newagapi_version311_clean.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONObject;

import java.io.IOException;
import java.util.regex.Pattern;

import fragments.InscriptionFragment;
import fragments.LoginFragment;
import helpers.FooterAuthentification;
import iut.dam.newagapi_version311_clean.R;
import helpers.BottomNavControler;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import helpers.FooterAuthentification;

public class Login_Inscription extends AppCompatActivity {

    private Button buttonInscriptionTitre, buttonConnectionTitre;
    private OkHttpClient client = new OkHttpClient();

    private EditText nomEditText, prenomEditText, emailEditTextRegister, motDePasseEditTextRegister;
    private EditText emailEditTextEmail, motDePasseEditTextEmail;

    Button buttonInscription, buttonConnection;
    View viewLeft, viewRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_inscription);
        buttonInscription = findViewById(R.id.titleInscription);
        buttonConnection = findViewById(R.id.titlebuttonConnexion);
        viewLeft = findViewById(R.id.viewLeft);
        viewRight = findViewById(R.id.viewRight);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer, new LoginFragment())
                .commit();

        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewLeft.setVisibility(View.INVISIBLE);
                viewRight.setVisibility(View.VISIBLE);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, new InscriptionFragment())
                        .commit();
            }
        });

        buttonConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewLeft.setVisibility(View.VISIBLE);
                viewRight.setVisibility(View.INVISIBLE);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, new LoginFragment())
                        .commit();
            }
        });

        FooterAuthentification.retournPage(this);



        // connexion
        emailEditTextEmail = findViewById(R.id.login_email);
        motDePasseEditTextEmail = findViewById(R.id.editTextMdpLogin);
        Button loginButton = findViewById(R.id.buttonConnection);

        //inscription

        nomEditText = findViewById(R.id.editTextNom);
        prenomEditText = findViewById(R.id.editTextPrenom);


        emailEditTextRegister = findViewById(R.id.editTextTextEmailAddress);
        motDePasseEditTextRegister = findViewById(R.id.editTextMdpInscription);
        Button registerButton = findViewById(R.id.buttonInscription);

//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (validateInputsLogin()) {
//                    loginUser();
//                }
//            }
//        });
//
//
//        registerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (validateInputsInscription()) {
//                    registerUser();
//                }
//            }
//        });


    }


    private void loginUser() {
        String email = emailEditTextEmail.getText().toString();
        String motDePasse = motDePasseEditTextEmail.getText().toString();

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
                        Toast.makeText(Login_Inscription.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(Login_Inscription.this, message, Toast.LENGTH_SHORT).show();
                                if (success) {
                                    // Rediriger vers l'écran principal ou l'écran d'accueil
                                    Intent intent = new Intent(Login_Inscription.this, Acceuil.class);
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
    private void registerUser() {
        String nom = nomEditText.getText().toString();
        String prenom = prenomEditText.getText().toString();
        String email = emailEditTextRegister.getText().toString();
        String motDePasse = motDePasseEditTextRegister.getText().toString();


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
                        Toast.makeText(Login_Inscription.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(Login_Inscription.this, message, Toast.LENGTH_SHORT).show();
                                if (success) {
//                                    Intent intent = new Intent(Login_Inscription.this, LoginActivity2.class);
//                                    startActivity(intent);
//                                    finish();
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
    private boolean validateInputsLogin() {
        String email = emailEditTextEmail.getText().toString().trim();
        String motDePasse = motDePasseEditTextEmail.getText().toString().trim();

        // Vérification si l'email est vide
        if (email.isEmpty()) {
            Toast.makeText(Login_Inscription.this, "L'email ne peut pas être vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification de l'email
        if (!isValidEmail(email)) {
            Toast.makeText(Login_Inscription.this, "Email invalide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification si le mot de passe est vide
        if (motDePasse.isEmpty()) {
            Toast.makeText(Login_Inscription.this, "Le mot de passe ne peut pas être vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    private boolean validateInputsInscription() {
        String email = emailEditTextRegister.getText().toString().trim();
        String motDePasse = motDePasseEditTextRegister.getText().toString().trim();

        // Vérification si l'email est vide
        if (email.isEmpty()) {
            Toast.makeText(Login_Inscription.this, "L'email ne peut pas être vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification de l'email
        if (!isValidEmail(email)) {
            Toast.makeText(Login_Inscription.this, "Email invalide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification si le mot de passe est vide
        if (motDePasse.isEmpty()) {
            Toast.makeText(Login_Inscription.this, "Le mot de passe ne peut pas être vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification du mot de passe
        if (!isValidPassword(motDePasse)) {
            Toast.makeText(Login_Inscription.this, "Le mot de passe doit contenir au moins un chiffre, une lettre majuscule, une lettre minuscule, un caractère spécial, et faire au moins 8 caractères", Toast.LENGTH_SHORT).show();
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
