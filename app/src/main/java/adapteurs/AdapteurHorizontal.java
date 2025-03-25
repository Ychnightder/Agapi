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
import iut.dam.newagapi_version311_clean.R;


public class AdapteurHorizontal extends RecyclerView.Adapter<AdapteurHorizontal.MyViewHolder> {
    Context context;
    ArrayList<ModeleHorizontalscrollview> modeleHorizontalscrollviews;
    public AdapteurHorizontal(Context context, ArrayList<ModeleHorizontalscrollview> modeleHorizontalscrollviews){
        this.context = context;
        this.modeleHorizontalscrollviews = modeleHorizontalscrollviews;
    }

    @NonNull
    @Override
    public AdapteurHorizontal.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inlater = LayoutInflater.from(context);
        View view = inlater.inflate(R.layout.accueil_recycleviewhorizontal, parent, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new AdapteurHorizontal.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(modeleHorizontalscrollviews.get(position).getNomAssociation());
        holder.imageButton.setImageResource(modeleHorizontalscrollviews.get(position).getImageAssociation());
    }

    @Override
    public int getItemCount() {
        return modeleHorizontalscrollviews.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageButton imageButton;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButton = itemView.findViewById(R.id.imageButton);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
