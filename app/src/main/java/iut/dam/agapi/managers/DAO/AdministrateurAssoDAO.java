package iut.dam.agapi.managers.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import iut.dam.agapi.managers.models.AdministrateurAsso;

@Dao
public interface AdministrateurAssoDAO {
    @Insert
    void insert(AdministrateurAsso administrateurAsso);

    @Query("SELECT * FROM AdministrateurAsso WHERE Id_admin = :idAdmin")
    AdministrateurAsso getAdministrateurAssoById(String idAdmin);
}
