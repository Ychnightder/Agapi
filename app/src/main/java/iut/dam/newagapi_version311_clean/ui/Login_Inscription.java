package iut.dam.newagapi_version311_clean.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import fragments.InscriptionFragment;
import fragments.LoginFragment;
import iut.dam.newagapi_version311_clean.R;

public class Login_Inscription extends AppCompatActivity {
    Button buttonInscription, buttonConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_inscirption);
        buttonInscription = findViewById(R.id.titleInscription);
        buttonConnection = findViewById(R.id.titlebuttonConnexion);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer, new LoginFragment())
                .commit();

        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG", "Inscription button clicked!");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, new InscriptionFragment())
                        .commit();
            }
        });

        buttonConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG", "Inscription button clicked!");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, new LoginFragment())
                        .commit();
            }
        });

    }
}
