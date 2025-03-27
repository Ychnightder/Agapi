package Models;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

                JsonArray jsonArray = JsonParser.parseString(jsonResponse).getAsJsonArray();
                List<Association> associations = new ArrayList<>();

                for (JsonElement element : jsonArray) {
                    Association asso = gson.fromJson(element, Association.class);

                    //separer les URL par des |
                    if (asso.getImagePresentationRaw() != null && !asso.getImagePresentationRaw().isEmpty()) {
                        List<String> imageList = new ArrayList<>();
                        String[] imageArray = asso.getImagePresentationRaw().split("\\|");
                        for (String url : imageArray) {
                            url = url.trim();
                            if (!url.isEmpty()) {
                                imageList.add(url);
                            }
                        }
                        asso.setImagePresentation(imageList);
                    } else {
                        Log.w("DEBUG_IMAGE", "Association " + asso.getNom_association() + " has empty imagePresentationRaw");
                    }


                    associations.add(asso);
                }

                return associations;
            } else {
                Log.e("API Error", "Erreur lors de la récupération des données : " + response.code());
                return null;
            }
        } catch (IOException e) {
            Log.e("API Error", "Exception lors de la requête API", e);
            return null;
        }
    }
}
