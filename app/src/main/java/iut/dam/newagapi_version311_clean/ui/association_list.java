package iut.dam.newagapi_version311_clean.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Models.ModeleHorizontalscrollview;
import Models.ModeleVerticalScrollViewList;
import adapteurs.AdapteurAssociationGrid;
import adapteurs.AdapteurAssociationList;
import iut.dam.newagapi_version311_clean.R;

public class association_list extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.associations_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewAssociationList);

        ArrayList<ModeleVerticalScrollViewList> list = new ArrayList<>();
        //partie test
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso1"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso2"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso3"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso4"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso5"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso6"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso7"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso1"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso2"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso3"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso4"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso5"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso6"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso7"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso1"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso2"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso3"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso4"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso5"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso6"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso7"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso1"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso2"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso3"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso4"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso5"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso6"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso7"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso1"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso2"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso3"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso4"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso5"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso6"));
        list.add(new ModeleVerticalScrollViewList(R.drawable.profil_noir, "Asso7"));
        // fin de la partie test
        AdapteurAssociationList adapter = new AdapteurAssociationList(this.getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }

}
