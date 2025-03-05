package iut.dam.agapi.managersV2.models;
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
    public String date_inscription;
}
