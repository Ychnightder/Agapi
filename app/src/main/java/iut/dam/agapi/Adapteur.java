package iut.dam.agapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapteur extends RecyclerView.Adapter<Adapteur.MyViewHolder> {
    Context context;
    ArrayList<ModeleHorizontalscrollview> modeleHorizontalscrollviews;
    public Adapteur(Context context, ArrayList<ModeleHorizontalscrollview> modeleHorizontalscrollviews){
        this.context = context;
        this.modeleHorizontalscrollviews = modeleHorizontalscrollviews;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inlater = LayoutInflater.from(context);
        View view = inlater.inflate(R.layout.buttonimagetext, parent, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); // 确保 item 不占满
        return new MyViewHolder(view);
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
