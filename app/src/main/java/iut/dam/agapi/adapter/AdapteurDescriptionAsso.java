package iut.dam.agapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import iut.dam.agapi.models.ModeleDescriptionAssociation;
import iut.dam.agapi.R;

public class AdapteurDescriptionAsso extends RecyclerView.Adapter<AdapteurDescriptionAsso.MyViewHolder> {
    Context context;
    ArrayList<ModeleDescriptionAssociation> modeleDescriptionAssociations;
    public AdapteurDescriptionAsso(Context context, ArrayList<ModeleDescriptionAssociation> modeleDescriptionAssociations){
        this.context = context;
        this.modeleDescriptionAssociations = modeleDescriptionAssociations;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inlater = LayoutInflater.from(context);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.descriptionacceuil, parent, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nomAsso.setText(modeleDescriptionAssociations.get(position).getNomAssociation());
        holder.descriptionAsso.setText(modeleDescriptionAssociations.get(position).getDescriptionAsso());
        holder.iconeAsso.setImageResource(modeleDescriptionAssociations.get(position).getIconeAssociation());
        holder.imageAsso.setImageResource(modeleDescriptionAssociations.get(position).getImageAssociation());
    }

    @Override
    public int getItemCount() {
        return modeleDescriptionAssociations.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

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
