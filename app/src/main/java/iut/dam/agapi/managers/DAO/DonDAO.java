package iut.dam.agapi.managers.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import iut.dam.agapi.managers.models.Don;

@Dao
public interface DonDAO {
    @Insert
    void insert(Don don);

    @Query("SELECT * FROM Don")
    List<Don> getAllDons();
}
