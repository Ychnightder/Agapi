package helpers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import iut.dam.newagapi_version311_clean.ui.Page_association;

public class Redirection {
    public static void clickEvent(Context context) {
        Intent intent = new Intent(context, Page_association.class);
        context.startActivity(intent);

    }

}
