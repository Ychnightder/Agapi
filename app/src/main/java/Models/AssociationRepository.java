package Models;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
public class AssociationRepository {

    private static final String BASE_URL = "https://ychnightder.alwaysdata.net/association.php";

    public List<Association> getAssociationsFromApi() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Gson gson = new Gson();
                Type associationListType = new TypeToken<List<Association>>() {}.getType();
                List<Association> associations = gson.fromJson(jsonResponse, associationListType);

                // Transforme l'URL de présentation en liste d'images
                for (Association association : associations) {
                    if (association.getImageUrls() != null && !association.getImageUrls().isEmpty()) {
                        List<String> imageList = new ArrayList<>();
                        String[] imageArray = association.getImageUrls().split("\\|"); // Divise les images par le séparateur '|'
                        for (String imageUrl : imageArray) {
                            imageList.add(imageUrl.trim());
                        }
                        association.setImagePresentation(imageList); // Mets à jour la liste des images
                    }
                }

                return associations;
            } else {
                Log.e("API Error", "Erreur lors de la récupération des données : " + response.code());
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("API Error", "Exception lors de la requête API", e);
            return null;
        }
    }



}
