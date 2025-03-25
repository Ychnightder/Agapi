package fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.regex.Pattern;

import iut.dam.newagapi_version311_clean.R;
import iut.dam.newagapi_version311_clean.ui.Accueil;
import iut.dam.newagapi_version311_clean.ui.Login_Inscription;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginFragment extends Fragment {
    private OkHttpClient client = new OkHttpClient();
    private EditText emailEditTextEmail, motDePasseEditTextEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);



        emailEditTextEmail = view.findViewById(R.id.login_email);
        motDePasseEditTextEmail = view.findViewById(R.id.editTextMdpLogin);
        Button loginButton = view.findViewById(R.id.buttonConnection);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputsLogin()) {
                    loginUser();
                }
            }
        });
        return view;
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
                requireActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Context context = getActivity();
                        Toast.makeText(context, "Erreur de connexion", Toast.LENGTH_SHORT).show();
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

                        requireActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Context context = getActivity();
                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                                if (success) {
                                    // Rediriger vers l'écran principal ou l'écran d'accueil
//                                    Intent intent = new Intent(context, Acceuil.class);
//                                    startActivity(intent);
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
        Context context = getActivity();
        // Vérification si l'email est vide
        if (email.isEmpty()) {
            Toast.makeText(context, "L'email ne peut pas être vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification de l'email
        if (!isValidEmail(email)) {
            Toast.makeText(context, "Email invalide", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification si le mot de passe est vide
        if (motDePasse.isEmpty()) {
            Toast.makeText(context, "Le mot de passe ne peut pas être vide", Toast.LENGTH_SHORT).show();
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


