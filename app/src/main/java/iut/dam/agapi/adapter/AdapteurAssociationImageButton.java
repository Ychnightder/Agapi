package iut.dam.agapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import iut.dam.agapi.models.ModelAssociationImageButton;
import iut.dam.agapi.R;

public class AdapteurAssociationImageButton extends RecyclerView.Adapter<AdapteurAssociationImageButton.MyViewHolder> {

    Context context;

    ArrayList<ModelAssociationImageButton> modelAssociationImageButtons;

    public AdapteurAssociationImageButton(Context context, ArrayList<ModelAssociationImageButton> modelAssociationImageButtons) {
        this.context = context;
        this.modelAssociationImageButtons = modelAssociationImageButtons;
    }

    @NonNull
    @Override
    public AdapteurAssociationImageButton.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inlater = LayoutInflater.from(context);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.associationimagebutton, parent, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapteurAssociationImageButton.MyViewHolder holder, int position) {
        if (position * 3 < modelAssociationImageButtons.size()) {
            holder.imageButtonAsso1.setImageResource(modelAssociationImageButtons.get(position * 3).getImageButton());
            holder.textViewAsso1.setText(modelAssociationImageButtons.get(position * 3).getNomAsso());
        }
        if (position * 3 + 1 < modelAssociationImageButtons.size()) {
            holder.imageButtonAsso2.setImageResource(modelAssociationImageButtons.get(position * 3 + 1).getImageButton());
            holder.textViewAsso2.setText(modelAssociationImageButtons.get(position * 3 + 1).getNomAsso());
        }
        if (position * 3 + 2 < modelAssociationImageButtons.size()) {
            holder.imageButtonAsso3.setImageResource(modelAssociationImageButtons.get(position * 3 + 2).getImageButton());
            holder.textViewAsso3.setText(modelAssociationImageButtons.get(position * 3 + 2).getNomAsso());
        }
    }

    @Override
    public int getItemCount() {
        return (int) Math.ceil(modelAssociationImageButtons.size() / 3.0);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageButton imageButtonAsso1, imageButtonAsso2,imageButtonAsso3;
        TextView textViewAsso1, textViewAsso2,textViewAsso3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButtonAsso1 = itemView.findViewById(R.id.imageButtonAsso1);
            imageButtonAsso2 = itemView.findViewById(R.id.imageButtonAsso2);
            imageButtonAsso3 = itemView.findViewById(R.id.imageButtonAsso3);
            textViewAsso1 = itemView.findViewById(R.id.textViewAsso1);
            textViewAsso2 = itemView.findViewById(R.id.textViewAsso2);
            textViewAsso3 = itemView.findViewById(R.id.textViewAsso3);

        }
    }
}




