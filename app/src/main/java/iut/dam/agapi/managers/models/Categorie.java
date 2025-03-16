package iut.dam.agapi.managers.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Categorie {
    @PrimaryKey(autoGenerate = true)
    public int idCategorie;
    public String categorie;
}
