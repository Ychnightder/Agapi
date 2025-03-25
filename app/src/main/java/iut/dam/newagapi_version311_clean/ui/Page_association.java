package iut.dam.newagapi_version311_clean.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import iut.dam.newagapi_version311_clean.R;

public class Page_association extends AppCompatActivity {

    Button buttonDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_association);
        buttonDon = findViewById(R.id.buttonDon);

        buttonDon.setOnClickListener(v -> {
            Intent intent = new Intent(this, Page_Don.class);
            startActivity(intent);
            finish();
        });
    }

}
