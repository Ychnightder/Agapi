package iut.dam.agapi.managers.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categorie {
    @PrimaryKey
    @NonNull
    public String idCategorie;
    public String categorie;
}
