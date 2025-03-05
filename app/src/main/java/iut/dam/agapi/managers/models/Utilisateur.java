package iut.dam.agapi.managers.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Utilisateur")
public class Utilisateur {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_utilisateur")
    public int idUtilisateur;
    public String nom;
    public String prenom_;
    public String email_;
    public String mot_de_passe_;
    public String date_inscription_;
}
