package iut.dam.agapi.managers.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Utilisateur {
    @PrimaryKey(autoGenerate = true)
    public int id_utilisateur;
    public String nom;
    public String prenom;
    public String email;
    public String mot_de_passe;
    public long date_inscription; // Utilisez long pour stocker les dates en millisecondes
}


