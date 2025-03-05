package iut.dam.agapi.managers.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import iut.dam.agapi.managers.models.Rapport;

@Dao
public interface RapportDAO {
    @Insert
    void insert(Rapport rapport);

    @Query("SELECT * FROM Rapport WHERE id_rapport = :idRapport")
    Rapport getRapportById(int idRapport);
}