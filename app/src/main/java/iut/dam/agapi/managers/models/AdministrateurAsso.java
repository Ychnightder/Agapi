package iut.dam.agapi.managers.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Association.class,
                        parentColumns = "id_association",
                        childColumns = "id_association",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Utilisateur.class,
                        parentColumns = "id_utilisateur",
                        childColumns = "id_utilisateur",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class AdministrateurAsso {
    @PrimaryKey(autoGenerate = true)
    public int Id_admin;
    public int id_association;
    public int id_utilisateur;
}
