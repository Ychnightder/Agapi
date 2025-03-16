package iut.dam.agapi.managers.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import iut.dam.agapi.managers.models.Association;

@Dao
public interface AssociationDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Association association);

    @Query("SELECT * FROM Association WHERE idCategorie = :idCategorie")
    List<Association> getAssociationsByCategorie(String idCategorie);
}
