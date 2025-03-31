package adapteurs;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

import Models.Association;
import iut.dam.newagapi_version311_clean.R;
import iut.dam.newagapi_version311_clean.ui.Page_association;

public class AdapteurAssociationList extends RecyclerView.Adapter<AdapteurAssociationList.MyViewHolder> {

    Context context;
    ArrayList<Association> modeleDescriptionAssociations;

    public AdapteurAssociationList(Context context, ArrayList<Association> modeleDescriptionAssociations) {
        this.context = context;
        this.modeleDescriptionAssociations = modeleDescriptionAssociations;
    }

    @NonNull
    @Override
    public AdapteurAssociationList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.associations_modele_list, parent, false);
        return new AdapteurAssociationList.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapteurAssociationList.MyViewHolder holder, int position) {
        Association item = modeleDescriptionAssociations.get(position);

        holder.NomAssociationList.setText(item.getNom_association());


        Glide.with(context)
                .load(item.getLogo())
                .placeholder(R.drawable.charity)
                .into(holder.iconAssociation);

        Log.d("GLIDE_DEBUGLIST", "Image URL: " + item.getLogo());

        bindButton(holder.buttonVersPageAsso,context,item);
    }


    @Override
    public int getItemCount() {
        return modeleDescriptionAssociations.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageButton iconAssociation;
        Button buttonVersPageAsso;
        TextView NomAssociationList;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iconAssociation = itemView.findViewById(R.id.iconAssociation);
            NomAssociationList = itemView.findViewById(R.id.NomAssociationList);
            buttonVersPageAsso = itemView.findViewById(R.id.buttonVersPageAsso);
        }
    }
    private  void bindButton(Button button, Context context, Association association) {
        button.setOnClickListener(v -> {
            String nom = association.getNom_association();
            android.util.Log.d("DEBUG_BIND", "Nom envoyé = " + nom);

            Intent intent = new Intent(context, Page_association.class);
            intent.putExtra("nom_association", nom);
            context.startActivity(intent);
        });
    }

}