package iut.dam.agapi.managers.models;

import androidx.room.ColumnInfo;
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
        )
)
public class Rapport {
    @PrimaryKey(autoGenerate = true)
    public int id_rapport;
    public String rapport;
    public long date_rapport;
    public int Id_admin;
}
