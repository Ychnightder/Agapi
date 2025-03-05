package iut.dam.agapi.managersV2.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Association {
    @PrimaryKey(autoGenerate = true)
    public int id_association;

    public String nom_association;
    public String description;
    public String logo;
    public String qrCode;
    public String site_web;
    public int id_categorie;
}