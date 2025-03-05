package iut.dam.agapi.managers.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import iut.dam.agapi.managers.models.Administrateur;


@Dao
public interface AdministrateurDAO {
    @Insert
    void insert(Administrateur administrateur);

    @Query("SELECT * FROM Administrateur WHERE Id_admin = :idAdmin")
    Administrateur getAdministrateurById(String idAdmin);
}
