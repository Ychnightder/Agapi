package iut.dam.newagapi_version311_clean.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import iut.dam.newagapi_version311_clean.R;


public class Splash extends AppCompatActivity {
    private static final int SPLASH_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Uri data = getIntent().getData();
        final String associationId = (data != null && "donsante".equals(data.getScheme()))
                ? data.getQueryParameter("id")
                : null;

        new Handler().postDelayed(() -> {
            Intent intent;
            if (associationId != null) {
                intent = new Intent(Splash.this, Page_Don.class);
                intent.putExtra("associationId", associationId);
            } else {
                intent = new Intent(Splash.this, Accueil.class);
            }
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);
    }

}
