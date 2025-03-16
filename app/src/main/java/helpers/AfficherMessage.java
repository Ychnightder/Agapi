package helpers;
import android.widget.Toast;
import android.content.Context;
public class AfficherMessage {

    public static void afficherMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
