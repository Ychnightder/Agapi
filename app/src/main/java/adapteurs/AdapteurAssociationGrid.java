package adapteurs;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import Models.ModeleHorizontalscrollview;
import helpers.Redirection;
import iut.dam.newagapi_version311_clean.R;


public class AdapteurAssociationGrid extends RecyclerView.Adapter<AdapteurAssociationGrid.MyViewHolder> {

    Context context;


    ArrayList<ModeleHorizontalscrollview> modelAssociationImageButtons;

    public AdapteurAssociationGrid(Context context, ArrayList<ModeleHorizontalscrollview> modelAssociationImageButtons) {
        this.context = context;
        this.modelAssociationImageButtons = modelAssociationImageButtons;
    }

    @NonNull
    @Override
    public AdapteurAssociationGrid.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.associations_modele_grid, parent, false);

        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);

        return new AdapteurAssociationGrid.MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int index = position * 3;

        // Item 1
        if (index < modelAssociationImageButtons.size()) {
            Glide.with(context)
                    .load(modelAssociationImageButtons.get(index).getImageAssociationUrl())
                    .placeholder(R.drawable.charity)
                    .into(holder.imageButtonAsso1);

            holder.textViewAsso1.setText(modelAssociationImageButtons.get(index).getNomAssociation());
            holder.imageButtonAsso1.setVisibility(View.VISIBLE);
            holder.textViewAsso1.setVisibility(View.VISIBLE);
            bindButton(holder.imageButtonAsso1);
        } else {
            holder.imageButtonAsso1.setVisibility(View.GONE);
            holder.textViewAsso1.setVisibility(View.GONE);
        }

        // Item 2
        if (index + 1 < modelAssociationImageButtons.size()) {
            Glide.with(context)
                    .load(modelAssociationImageButtons.get(index + 1).getImageAssociationUrl())
                    .placeholder(R.drawable.charity)
                    .into(holder.imageButtonAsso2);

            holder.textViewAsso2.setText(modelAssociationImageButtons.get(index + 1).getNomAssociation());
            holder.imageButtonAsso2.setVisibility(View.VISIBLE);
            holder.textViewAsso2.setVisibility(View.VISIBLE);
            bindButton(holder.imageButtonAsso2);
        } else {
            holder.imageButtonAsso2.setVisibility(View.INVISIBLE);
            holder.textViewAsso2.setVisibility(View.INVISIBLE);
        }

        // Item 3
        if (index + 2 < modelAssociationImageButtons.size()) {
            Glide.with(context)
                    .load(modelAssociationImageButtons.get(index + 2).getImageAssociationUrl())
                    .placeholder(R.drawable.charity)
                    .into(holder.imageButtonAsso3);

            holder.textViewAsso3.setText(modelAssociationImageButtons.get(index + 2).getNomAssociation());
            holder.imageButtonAsso3.setVisibility(View.VISIBLE);
            holder.textViewAsso3.setVisibility(View.VISIBLE);
            bindButton(holder.imageButtonAsso3);
        } else {
            holder.imageButtonAsso3.setVisibility(View.INVISIBLE);
            holder.textViewAsso3.setVisibility(View.INVISIBLE);
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
    private void bindButton(ImageButton button) {
            button.setOnClickListener(v -> Redirection.clickEvent(context));
    }

}




