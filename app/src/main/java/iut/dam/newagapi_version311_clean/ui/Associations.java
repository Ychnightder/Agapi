package iut.dam.newagapi_version311_clean.ui;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import helpers.BottomNavControler;
import iut.dam.newagapi_version311_clean.R;
import static helpers.CouleursPourText.getCouleurOnclick;


public class Associations extends AppCompatActivity {
    FrameLayout frameLayout;
    ImageButton buttonFilter, buttonAssociations;
    TextView textViewAssociations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.associations);
        buttonAssociations = findViewById(R.id.buttonAsso);
        frameLayout = findViewById(R.id.frameContainer);
        buttonFilter = findViewById(R.id.buttonFilter);
        textViewAssociations = findViewById(R.id.textViewAssociations);
        buttonAssociations.setImageResource(R.drawable.bottomnav_charityonclick);
        textViewAssociations.setTextColor(getCouleurOnclick());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameContainer, new association_list())
                .commit();

        buttonFilter.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameContainer, new association_grid())
                    .commit();
        });
        BottomNavControler.setupNavigation(this);

    }

}
