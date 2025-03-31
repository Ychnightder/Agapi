package helpers;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.gson.Gson;

import iut.dam.newagapi_version311_clean.ui.Page_association;
import Models.Association;

public class ButtonRedirection {
    public static void bindImageButton(ImageButton button, Context context, Association association) {
        button.setOnClickListener(v -> {
            Intent intent = new Intent(context, Page_association.class);
            intent.putExtra("nom_association", association.getNom_association());

            context.startActivity(intent);
        });
    }


}