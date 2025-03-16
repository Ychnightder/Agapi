package iut.dam.newagapi_version311_clean.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Models.ModeleHorizontalscrollview;
import adapteurs.AdapteurAssociationGrid;
import iut.dam.newagapi_version311_clean.R;

public class association_grid extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.associations_grid, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewAssociationGrid);

        ArrayList<ModeleHorizontalscrollview> list = new ArrayList<>();
        //partie test
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso1"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso2"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso3"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso4"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso5"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso6"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso7"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso1"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso2"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso3"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso4"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso5"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso6"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso7"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso1"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso2"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso3"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso4"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso5"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso6"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso7"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso1"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso2"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso3"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso4"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso5"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso6"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso7"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso1"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso2"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso3"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso4"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso5"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso6"));
        list.add(new ModeleHorizontalscrollview(R.drawable.profil, "Asso7"));
        // fin de la partie test
        AdapteurAssociationGrid adapter = new AdapteurAssociationGrid(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }

}