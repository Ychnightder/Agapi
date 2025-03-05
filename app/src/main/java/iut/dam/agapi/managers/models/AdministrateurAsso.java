package iut.dam.agapi.managers.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Administrateur.class,
                        parentColumns = "Id_admin",
                        childColumns = "Id_admin",
                        onDelete = ForeignKey.CASCADE
                ),
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
        },
        indices = {@Index("Id_admin"), @Index("id_association"), @Index("id_utilisateur")}
)
public class AdministrateurAsso {
    @PrimaryKey
    @NonNull
    public String Id_admin;
    public int id_association;
    public int id_utilisateur;
}