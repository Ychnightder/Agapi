package iut.dam.agapi.managersV2.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categorie {
    @PrimaryKey(autoGenerate = true)
    public int id_categorie;
    public String categorie;
}
