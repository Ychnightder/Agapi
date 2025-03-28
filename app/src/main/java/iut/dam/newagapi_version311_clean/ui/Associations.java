package iut.dam.newagapi_version311_clean.ui;



import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import helpers.BottomNavControler;
import helpers.CouleursPourText;
import iut.dam.newagapi_version311_clean.R;



public class Associations extends AppCompatActivity {
    FrameLayout frameLayout;
    ImageButton buttonFilter, buttonAssociations;
    TextView textViewAssociations;
    private Boolean estEnList = true;
    private final int couleurOnclick = Color.parseColor("#F2409D");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.associations);
        buttonAssociations = findViewById(R.id.buttonAsso);
        frameLayout = findViewById(R.id.frameContainer);
        buttonFilter = findViewById(R.id.buttonFilter);
        textViewAssociations = findViewById(R.id.textViewAssociations);
        buttonAssociations.setImageResource(R.drawable.bottomnav_charityonclick);
        textViewAssociations.setTextColor(couleurOnclick);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameContainer, new association_list())
                .commit();

        buttonFilter.setOnClickListener(v -> {
            if (estEnList) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameContainer, new association_grid())
                        .commit();
                estEnList = false;
            }
            else {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameContainer, new association_list())
                        .commit();
                estEnList = true;
            }
        });
        BottomNavControler.setupNavigation(this);

    }

}
