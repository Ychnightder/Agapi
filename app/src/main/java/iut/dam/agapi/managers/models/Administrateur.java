package iut.dam.agapi.managers.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = @ForeignKey(
                entity = Utilisateur.class,
                parentColumns = "id_utilisateur",
                childColumns = "id_utilisateur",
                onDelete = ForeignKey.CASCADE
        )
)
public class Administrateur {
    @PrimaryKey(autoGenerate = true)
    public int Id_admin;
    public int id_utilisateur;
}

