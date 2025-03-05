package iut.dam.agapi.managersV2.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Don {
    @PrimaryKey(autoGenerate = true)
    public int id_don;

    public double montant;
    public String date_don;
    public String type_don;
    public int id_utilisateur; // l'utilisateur peut être null
    public int id_association;
}

