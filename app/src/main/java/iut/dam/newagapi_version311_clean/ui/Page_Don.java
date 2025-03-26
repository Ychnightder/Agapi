package iut.dam.newagapi_version311_clean.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import helpers.BottomNavControler;
import iut.dam.newagapi_version311_clean.R;

public class Page_Don extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_don);
        BottomNavControler.setupNavigation(this);

    }
}
