package iut.dam.agapi.managersV2.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AdministrateurAsso  extends Utilisateur{
    @PrimaryKey(autoGenerate = true)
    public int id_admin;

    public int id_association;
    public int id_utilisateur;
}
