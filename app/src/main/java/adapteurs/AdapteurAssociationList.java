package adapteurs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Models.ModeleHorizontalscrollview;
import Models.ModeleVerticalScrollViewList;
import helpers.Redirection;
import iut.dam.newagapi_version311_clean.R;


public class AdapteurAssociationList extends RecyclerView.Adapter<AdapteurAssociationList.MyViewHolder> {

    Context context;


    ArrayList<ModeleVerticalScrollViewList> modelAssociationImageButtons;

    public AdapteurAssociationList(Context context, ArrayList<ModeleVerticalScrollViewList> modelAssociationImageButtons) {
        this.context = context;
        this.modelAssociationImageButtons = modelAssociationImageButtons;
    }

    @NonNull
    @Override
    public AdapteurAssociationList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.associations_modele_list, parent, false);

        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);

        return new AdapteurAssociationList.MyViewHolder(view);
    }



    @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.NomAssociationList.setText(modelAssociationImageButtons.get(position).getNom_Asso());
        holder.iconAssociation.setImageResource(modelAssociationImageButtons.get(position).getIcon());
        bindButton(holder.iconAssociation);

    }

    @Override
    public int getItemCount() {
        return modelAssociationImageButtons.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageButton iconAssociation;
        TextView NomAssociationList;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iconAssociation = itemView.findViewById(R.id.iconAssociation);
            NomAssociationList = itemView.findViewById(R.id.NomAssociationList);


        }
    }
    private void bindButton(ImageButton button) {
            button.setOnClickListener(v -> Redirection.clickEvent(context));
    }

}




