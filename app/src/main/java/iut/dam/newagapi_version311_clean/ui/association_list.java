package iut.dam.newagapi_version311_clean.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import Models.Association;
import adapteurs.AdapteurAssociationList;
import iut.dam.newagapi_version311_clean.R;

public class association_list extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.associations_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewAssociationList);

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("ASSO_DATAList", Context.MODE_PRIVATE);
        String jsonList = sharedPreferences.getString("VerticalList", null);

        ArrayList<Association> list = new ArrayList<>();
        if (jsonList != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Association>>() {}.getType();
            list = gson.fromJson(jsonList, type);
        }

        AdapteurAssociationList adapter = new AdapteurAssociationList(requireContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
