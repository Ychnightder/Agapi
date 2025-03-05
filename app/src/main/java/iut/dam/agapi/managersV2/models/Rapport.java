package iut.dam.agapi.managersV2.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Rapport {
    @PrimaryKey(autoGenerate = true)
    public int id_rapport;

    public String rapport;
    public String date_rapport;
    public int id_admin;
}
