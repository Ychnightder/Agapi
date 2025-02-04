package iut.dam.agapi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ModeleHorizontalscrollview> modeleHorizontalscrollviews = new ArrayList<>();
    int[] ImageAssociation = {
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        setModeleHorizontalscrollviews();
        Adapteur adapteur = new Adapteur(this, modeleHorizontalscrollviews);
        recyclerView.setAdapter(adapteur);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }
    private void setModeleHorizontalscrollviews() {
        String[] ListeAsso = getResources().getStringArray(R.array.nom_association);
        for (int i = 0; i < ListeAsso.length; i++) {
            modeleHorizontalscrollviews.add(
                    new ModeleHorizontalscrollview( ImageAssociation[i] , ListeAsso[i])
            );
        }
    }
}