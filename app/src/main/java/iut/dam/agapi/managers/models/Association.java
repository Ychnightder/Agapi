package iut.dam.agapi.managers.models;

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
        ),
        indices = {@Index("idCategorie")}
)
public class Association {
    @PrimaryKey(autoGenerate = true)
    public int id_association;
    public String nom_association_;
    public String Description_;
    public String Logo_;
    public String QRCode_;
    public String site_web_;
    public String idCategorie;
}