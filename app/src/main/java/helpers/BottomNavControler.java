package helpers;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.TextView;

import iut.dam.newagapi_version311_clean.R;
import iut.dam.newagapi_version311_clean.ui.Associations;
import iut.dam.newagapi_version311_clean.ui.Acceuil;
import iut.dam.newagapi_version311_clean.ui.Login;

public class BottomNavControler {

    public static void setupNavigation(Activity activity, int activeButtonId) {
        ImageButton buttonAccueil = activity.findViewById(R.id.buttonAcceuil);
        ImageButton buttonAsso = activity.findViewById(R.id.buttonAsso);
        ImageButton buttonProfil = activity.findViewById(R.id.buttonProfil);

        TextView textAccueil = activity.findViewById(R.id.textViewAccueil);
        TextView textAsso = activity.findViewById(R.id.textViewAssociations);
        TextView textProfil = activity.findViewById(R.id.textViewProfil);


        int defaultColor = CouleursPourText.getDefaultCouleur();


        textAccueil.setTextColor(defaultColor);
        textAsso.setTextColor(defaultColor);
        textProfil.setTextColor(defaultColor);

        buttonAccueil.setOnClickListener(v -> {
            if (activity.getClass() != Acceuil.class) {
                activity.startActivity(new Intent(activity, Acceuil.class));
                activity.overridePendingTransition(0, 0);
            }
        });

        buttonAsso.setOnClickListener(v -> {
            if (activity.getClass() != Associations.class) {
                activity.startActivity(new Intent(activity, Associations.class));
                activity.overridePendingTransition(0, 0);
            }
        });

        buttonProfil.setOnClickListener(v -> {
            if (activity.getClass() != Login.class) {
                activity.startActivity(new Intent(activity, Login.class));
                activity.overridePendingTransition(0, 0);
                activity.finish();
            }
        });
    }
}
