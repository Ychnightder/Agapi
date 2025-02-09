package iut.dam.agapi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AssociationImageButton extends AppCompatActivity {
    ArrayList<ModelAssociationImageButton> modelAssociationImageButtons = new ArrayList<>();

    int[] ImageAssociation = {
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associationimage);
        RecyclerView recyclerViewImageButton = findViewById(R.id.recyclerViewImageButton);
        setRecycleView();
        AdapteurAssociationImageButton adapteurAssociationImageButton = new AdapteurAssociationImageButton(this, modelAssociationImageButtons);
        recyclerViewImageButton.setAdapter(adapteurAssociationImageButton);
        recyclerViewImageButton.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewImageButton.setNestedScrollingEnabled(false);

    }

    private void setRecycleView() {
        String[] ListeAsso = getResources().getStringArray(R.array.nom_association);
        for (int i = 0; i < ListeAsso.length; i++) {
            modelAssociationImageButtons.add(
                    new ModelAssociationImageButton(ImageAssociation[i], ListeAsso[i])
            );
        }
    }
}
