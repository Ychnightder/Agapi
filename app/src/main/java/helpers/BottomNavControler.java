package helpers;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import iut.dam.newagapi_version311_clean.R;
import iut.dam.newagapi_version311_clean.ui.Associations;
import iut.dam.newagapi_version311_clean.ui.Accueil;
import iut.dam.newagapi_version311_clean.ui.Login_Inscription;
import iut.dam.newagapi_version311_clean.ui.Profil;
import iut.dam.newagapi_version311_clean.ui.Profil_Admin;

public class BottomNavControler {

    public static void setupNavigation(Activity activity) {
        ImageButton buttonAccueil = activity.findViewById(R.id.buttonAccueil);
        ImageButton buttonAsso = activity.findViewById(R.id.buttonAsso);
        ImageButton buttonProfil = activity.findViewById(R.id.buttonProfil);

        TextView textAccueil = activity.findViewById(R.id.textViewAccueil);
        TextView textAsso = activity.findViewById(R.id.textViewAssociations);
        TextView textProfil = activity.findViewById(R.id.textViewProfil);


        int defaultColor = CouleursPourText.getDefaultCouleur();
        int couleurOnclick = CouleursPourText.getCouleurOnclick();


        textAccueil.setTextColor(defaultColor);
        textAsso.setTextColor(defaultColor);
        textProfil.setTextColor(defaultColor);

        buttonAccueil.setOnClickListener(v -> {
            if (activity.getClass() != Accueil.class) {
                activity.startActivity(new Intent(activity, Accueil.class));
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
            boolean isLoggedIn = activity.getSharedPreferences("MyAppPrefs", Activity.MODE_PRIVATE)
                    .getBoolean("isLoggedIn", false);
            Log.d("DEBUG_LOGIN", "isLoggedIn: " + isLoggedIn);


            Class<?> currentClass = activity.getClass();

            if (!isLoggedIn) {
                if (currentClass != Login_Inscription.class) {
                    activity.startActivity(new Intent(activity, Login_Inscription.class));
                    activity.overridePendingTransition(0, 0);
                }
            } else {
                boolean isAdmin = activity.getSharedPreferences("MyAppPrefs", Activity.MODE_PRIVATE)
                        .getBoolean("isAdmin", false);
                Log.d("DEBUG_LOGIN", "isAdmin: " + isAdmin);
                if (isAdmin && currentClass != Profil_Admin.class) {
                    activity.startActivity(new Intent(activity, Profil_Admin.class));
                    activity.overridePendingTransition(0, 0);
                } else if (!isAdmin && currentClass != Profil.class) {
                    activity.startActivity(new Intent(activity, Profil.class));
                    activity.overridePendingTransition(0, 0);
                }
            }
        });

    }
}
