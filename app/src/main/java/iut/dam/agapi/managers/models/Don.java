package iut.dam.agapi.managers.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Utilisateur.class,
                        parentColumns = "id_utilisateur",
                        childColumns = "id_utilisateur",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Association.class,
                        parentColumns = "id_association",
                        childColumns = "id_association",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class Don {
    @PrimaryKey(autoGenerate = true)
    public int id_don;
    public double montant;
    public long date_don;
    public String type_don;
    public int id_utilisateur;
    public int id_association;
}

