package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import iut.dam.newagapi_version311_clean.R;

public class AccueilFragment2Button extends Fragment {

    private Button buttonPourvous, buttonSuivies;
    private View viewPourvous, viewSuivies;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.accueil_2buttons, container, false);

        buttonPourvous = view.findViewById(R.id.buttonPourVous);
        buttonSuivies = view.findViewById(R.id.buttonSuivies);
        viewPourvous = view.findViewById(R.id.barButton_Pourvous);
        viewSuivies = view.findViewById(R.id.barButton_Suivis);

        buttonPourvous.setOnClickListener(v -> {
            viewPourvous.setVisibility(View.VISIBLE);
            viewSuivies.setVisibility(View.GONE);
        });

        buttonSuivies.setOnClickListener(v -> {
            viewPourvous.setVisibility(View.GONE);
            viewSuivies.setVisibility(View.VISIBLE);
        });

        return view;
    }
}
