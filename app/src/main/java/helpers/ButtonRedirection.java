package helpers;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageButton;

import iut.dam.newagapi_version311_clean.ui.Page_association;

public class ButtonRedirection {
    public static void bindButton(ImageButton button, Context context) {
        button.setOnClickListener(v -> redirection(context));
    }
    private static void redirection(Context context) {
        Intent intent = new Intent(context, Page_association.class);
        context.startActivity(intent);
    }
}