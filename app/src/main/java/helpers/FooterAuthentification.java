package helpers;
import android.app.Activity;
import android.widget.Button;
import iut.dam.newagapi_version311_clean.R;
public class FooterAuthentification {
    public static void retournPage(Activity activity) {
        Button closeButton = activity.findViewById(R.id.buttonRetourn);
        if (closeButton != null) {
            closeButton.setOnClickListener(v -> activity.finish());
        }
    }


}
