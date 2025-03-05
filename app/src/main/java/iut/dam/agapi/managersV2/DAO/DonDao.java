package iut.dam.agapi.managersV2.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import iut.dam.agapi.managersV2.models.Don;

@Dao
public interface DonDao {
    @Insert
    void insert(Don don);

    @Query("SELECT * FROM Don")
    List<Don> getAllDons();
}
