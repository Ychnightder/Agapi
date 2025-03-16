package iut.dam.agapi.managers.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = @ForeignKey(
                entity = Categorie.class,
                parentColumns = "idCategorie",
                childColumns = "idCategorie",
                onDelete = ForeignKey.CASCADE
        )
)
public class Association {
    @PrimaryKey(autoGenerate = true)
    public int id_association;
    public String nom_association;
    public String description;
    public String logo;
    public String QRCode;
    public String site_web;
    public int idCategorie;
}