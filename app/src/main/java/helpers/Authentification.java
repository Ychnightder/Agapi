package helpers;

import android.app.Activity;
import android.widget.EditText;
import static helpers.AfficherMessage.afficherMessage;


public class Authentification {

    public static void verifMDP(EditText mailTel, EditText editTextMDP){

    }

    public static void inscription(EditText mail, EditText mdp, EditText tel, Activity activity) {
        String messageErreur = "Veuillez entrer le mot de passe et l'adresse mail pour s'inscrire";

        String emailText = mail.getText().toString().trim();
        String mdpText = mdp.getText().toString().trim();

        if (emailText.isEmpty() || mdpText.isEmpty()) {
            afficherMessage(activity, messageErreur);
            return;
        }else {
            activity.finish();
        }

        if (!tel.getText().toString().trim().isEmpty()) {
            //enregistrer numero

        }
    }
}
