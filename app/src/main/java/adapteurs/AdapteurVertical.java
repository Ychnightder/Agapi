package adapteurs;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import iut.dam.newagapi_version311_clean.R;
import Models.ModeleVerticalscrollview;

public class AdapteurVertical extends RecyclerView.Adapter<AdapteurVertical.MyViewHolder> {

    Context context;
    ArrayList<ModeleVerticalscrollview> modeleDescriptionAssociations;

    public AdapteurVertical(Context context, ArrayList<ModeleVerticalscrollview> modeleDescriptionAssociations) {
        this.context = context;
        this.modeleDescriptionAssociations = modeleDescriptionAssociations;
    }

    @NonNull
    @Override
    public AdapteurVertical.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.accueil_recycleviewvertical, parent, false);
        return new AdapteurVertical.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModeleVerticalscrollview item = modeleDescriptionAssociations.get(position);

        holder.nomAsso.setText(item.getNomAssociation());
        holder.descriptionAsso.setText(item.getDescriptionAsso());

        //transforme URL en image
        //placeholder : si ya une erreur remplace image par image local (pour test)
        Glide.with(context)
                .load(item.getIconeAssociationUrl())
                .placeholder(R.drawable.charity)
                .into(holder.iconeAsso);

        Glide.with(context)
                .load(item.getImageAssociationUrl())
                .placeholder(R.drawable.charity)
                .into(holder.imageAsso);
        Log.d("GLIDE_DEBUG", "Image URL: " + item.getImageAssociationUrl());

    }

    @Override
    public int getItemCount() {
        return modeleDescriptionAssociations.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iconeAsso, imageAsso;
        TextView nomAsso, descriptionAsso;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iconeAsso = itemView.findViewById(R.id.Icon);
            imageAsso = itemView.findViewById(R.id.ImageAsso);
            nomAsso = itemView.findViewById(R.id.NomAsso);
            descriptionAsso = itemView.findViewById(R.id.Description);
        }
    }
}
