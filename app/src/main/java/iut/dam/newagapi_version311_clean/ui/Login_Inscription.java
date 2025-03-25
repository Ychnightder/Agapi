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

public class Login_Inscription extends AppCompatActivity {

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

    }


}
