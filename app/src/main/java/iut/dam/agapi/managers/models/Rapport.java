package iut.dam.agapi.managers.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(
        foreignKeys = @ForeignKey(
                entity = AdministrateurAsso.class,
                parentColumns = "Id_admin",
                childColumns = "Id_admin",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index("Id_admin")}
)
public class Rapport {
    @PrimaryKey(autoGenerate = true)
    public int id_rapport;
    public String rapport;
    public String date_rapport;
    public String Id_admin;
}
