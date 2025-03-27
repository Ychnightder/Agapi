package adapteurs;

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
import iut.dam.newagapi_version311_clean.R;

public class AdapteurHorizontal extends RecyclerView.Adapter<AdapteurHorizontal.MyViewHolder> {
    Context context;
    ArrayList<ModeleHorizontalscrollview> modeleHorizontalscrollviews;

    public AdapteurHorizontal(Context context, ArrayList<ModeleHorizontalscrollview> modeleHorizontalscrollviews) {
        this.context = context;
        this.modeleHorizontalscrollviews = modeleHorizontalscrollviews;
    }

    @NonNull
    @Override
    public AdapteurHorizontal.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.accueil_recycleviewhorizontal, parent, false);
        return new AdapteurHorizontal.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModeleHorizontalscrollview item = modeleHorizontalscrollviews.get(position);

        holder.textView.setText(item.getNomAssociation());

        Glide.with(context)
                .load(item.getImageAssociationUrl())
                .placeholder(R.drawable.charity)
                .into(holder.imageButton);
    }

    @Override
    public int getItemCount() {
        return modeleHorizontalscrollviews.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageButton imageButton;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.imageButton);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
