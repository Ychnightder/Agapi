package iut.dam.newagapi_version311_clean.ui;

import android.content.Intent;
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
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(Splash.this, Login.class));
            finish();
        }, SPLASH_DELAY);
    }
}
